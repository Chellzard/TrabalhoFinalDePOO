package com.loja.gui;

import com.loja.Peca;

import javax.swing.*;

// Código da tela que exibe a descrição do Item.
public class DescricaoUI {

    private JLabel labelNomePeca;
    private JPanel rootPanel;
    private JLabel labelDescricao;

    // Método construtor
    DescricaoUI(Peca peca) {
        labelNomePeca.setText(peca.getNome());
        labelDescricao.setText(peca.getDescricao());
    }

    // Retorna o Painel principal da tela.
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
