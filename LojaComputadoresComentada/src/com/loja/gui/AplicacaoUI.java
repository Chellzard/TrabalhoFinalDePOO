package com.loja.gui;

import com.loja.Peca;
import com.loja.TipoPeca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// Código da tela principal
public class AplicacaoUI {
    private JPanel rootPanel;
    private JTable tablePecas;
    private JPanel tablePecasPanel;
    private JLabel labelNome;
    private JTextField textFieldNome;
    private JTextField textFieldMarca;
    private JTextField textFieldEstoque;
    private JTextField textFieldValor;
    private JComboBox comboBoxTipo;
    private JButton novoButton;
    private JButton editarButton;
    private JButton excluirButton;
    private JButton buttonSalvar;
    private JLabel labelInvalidValues;
    private JTextField textFieldCodigo;
    private JLabel labelCodigo;
    private JLabel labelTotalPrice;
    private JTextArea textAreaDescricao;
    private JLabel labelDescricao;
    private int rowClicked = -1;

    // Lista de peças
    private List<Peca> pecas = new ArrayList<Peca>();

    // Dados da lista de peças para usar na tabela
    private Object[][] dataTablePecas = {};

    // Colunas da tabela
    private String[] columnsTablePeca = new String[] {"Código", "Nome", "Marca", "Estoque", "Valor", "Tipo"};

    // Valroes do comboBox TipoPeca. É pego os valores em um array do Enum TipoPeca
    private String[] comboBoxValues = Arrays.stream(TipoPeca.values()).map(Object::toString).toArray(String[]::new);

    /* Método construtor
        Aqui se faz as devidas alterações e criações (como da tabela por exemplo) ao criar a tela principal e também define os eventos
    */
    public AplicacaoUI() {
        labelInvalidValues.setVisible(false);
        textFieldCodigo.setText("0");
        comboBoxTipo.setModel(new DefaultComboBoxModel(comboBoxValues));
        comboBoxTipo.setSelectedIndex(0);
        createTablePecas();
        tablePecasPanel.setMaximumSize(new Dimension(100,100));
        tablePecas.setDefaultEditor(Object.class, null);        // Código serve para não permitir alteração dos dados direto na tabela
        buttonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSalvarClick();
            }
        });
        novoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNovoClick();
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEditarClick();
            }
        });
        tablePecas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableCollumnClicked(e);
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonExcluirClick();
            }
        });
        tablePecas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JTable table =(JTable) e.getSource();
                Point point = e.getPoint();
                int row = table.rowAtPoint(point);
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    viewDescricaoPeca(pecas.get(row));
                }
            }
        });
    }

    // Método que é chamado para instanciar certos componentes da Tela
    private void createUIComponents() {
        rootPanel = new JPanel();
        tablePecasPanel = new JPanel();
        comboBoxTipo = new JComboBox();
    }

    // Retorna o Painel principal da tela. O método main o usa para fazer as devidas alterações
    public JPanel getRootPanel() {
        return rootPanel;
    }

    // Cria a tabela de peças e faz as devidas modificações
    private void createTablePecas() {
        tablePecas.setModel(new DefaultTableModel(dataTablePecas, columnsTablePeca));
        TableColumnModel columns = tablePecas.getColumnModel();
        columns.getColumn(1).setMinWidth(200);
        tablePecas.setMinimumSize(new Dimension(100, 100));
    }

    /* Método que é chamado ao clicar no botão Salvar.
        Este método faz verificações para saber se é para salvar ou editar um certo item e logo após altera a tabela
        com os novos dados
    */
    private void buttonSalvarClick() {
        try {       // Os códigos dentro do try se derem algum erro, pula para o catch
            int codigo = Integer.parseInt(textFieldCodigo.getText());
            Peca peca = new Peca();
            peca.setNome(textFieldNome.getText());
            peca.setMarca(textFieldMarca.getText());
            peca.setEstoque(Integer.parseInt(textFieldEstoque.getText().isEmpty() ? "-1" : textFieldEstoque.getText()));
            peca.setValor(Float.parseFloat(textFieldValor.getText().isEmpty() ? "-1" : textFieldValor.getText()));
            peca.setTipoPeca(TipoPeca.valueOf(TipoPeca.values()[comboBoxTipo.getSelectedIndex()].toString()));
            peca.setDescricao(textAreaDescricao.getText());
            if (!isPecaValid(peca)) {
                labelInvalidValues.setVisible(true);
                return;
            }

            labelInvalidValues.setVisible(false);
            if (codigo >= pecas.size()) {       // pecas.size() => Pega o tamanho da lista. Por exemplo, se tiver 3 elementos, ele retorna 3, porém os index dos elementos vão de 0 a 2
                textFieldCodigo.setText(String.valueOf(pecas.size() + 1));
                pecas.add(peca);
            } else
                pecas.set(codigo, peca);
            changeTableData();
            clearInputs();
            rowClicked = -1;
            labelTotalPrice.setText("R$ " + getTotalOfPecas());
        } catch (Exception e) {
            labelInvalidValues.setVisible(true);
        }
    }

    // Método que é chamado ao clicar no botão Novo
    private void buttonNovoClick() {
        clearInputs();
        rowClicked = -1;
    }

    // Método que é chamado ao clicar no botão Editar
    private void buttonEditarClick() {
        if (rowClicked < 0 || rowClicked >= pecas.size())
            return;
        textFieldCodigo.setText(String.valueOf(rowClicked));
        Peca pecaClicked = pecas.get(rowClicked);           // Pega os valores da peca dentro da lista pecas de acordo com a linha clicada na tabela
        textFieldNome.setText(pecaClicked.getNome());
        textFieldMarca.setText(pecaClicked.getMarca());
        textFieldEstoque.setText(String.valueOf(pecaClicked.getEstoque()));
        textFieldValor.setText(String.valueOf(pecaClicked.getValor()));
        comboBoxTipo.setSelectedIndex(TipoPeca.valueOf(pecaClicked.getTipoPeca().toString()).ordinal());
        textAreaDescricao.setText(pecaClicked.getDescricao());
    }

    // Método que é chamado ao clicar no botão Excluir
    private void buttonExcluirClick() {
        if (rowClicked < 0 || rowClicked >= pecas.size())
            return;

        pecas.remove(rowClicked);
        changeTableData();
        rowClicked = -1;
        textFieldCodigo.setText(String.valueOf(pecas.size()));
        labelTotalPrice.setText("R$ " + getTotalOfPecas());
        clearInputs();
    }

    // Limpa (deixa vazio) todos os inputs da tela e deixa algumas coisa em default
    private void clearInputs() {
        textFieldCodigo.setText(String.valueOf(pecas.size()));
        textFieldNome.setText("");
        textFieldMarca.setText("");
        textFieldEstoque.setText("");
        textFieldValor.setText("");
        comboBoxTipo.setSelectedIndex(0);
        textAreaDescricao.setText("");
    }

    // Método que é chamado ao clicar em alguma coluna da tabela
    private void tableCollumnClicked(MouseEvent e) {
        rowClicked = tablePecas.rowAtPoint(e.getPoint());
    }

    // Método para mudar os valores na tabela a partir da Lista de Peças
    private void changeTableData() {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Código", "Nome", "Marca", "Estoque", "Valor", "Tipo", "Descrição"}, 0);

        int i = 0;
        for (Peca peca: pecas) {
            Object line[] = new Object[]{
                    i,
                    peca.getNome(),
                    peca.getMarca(),
                    peca.getEstoque(),
                    peca.getValor(),
                    peca.getTipoPeca(),
                    peca.getDescricao()
            };
            model.addRow(line);
            i++;
        }

        tablePecas.setModel(model);
    }

    // Retorna o valor total da Lista de Peças
    private float getTotalOfPecas() {
        return (float) pecas.stream().mapToDouble(p -> p.getValor() * p.getEstoque()).sum();
    }

    // Cria uma nova tela "DetalhesUI" e faz as devidas modificações
    private void viewDescricaoPeca(Peca peca) {
        DescricaoUI descricaoUI = new DescricaoUI(peca);
        JPanel rootDescricaoUI = descricaoUI.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(rootDescricaoUI);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setVisible(true);
    }

    // Verifica se a peça a ser salva é válida
    private boolean isPecaValid(Peca peca) {
        if (peca.getNome().trim().isEmpty() ||
        peca.getMarca().trim().isEmpty() ||
                peca.getDescricao().isEmpty() ||
        peca.getEstoque() < 0 ||
        peca.getValor() <= 0)
            return false;

        return true;
    }
}
