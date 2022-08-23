import java.awt.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import com.loja.*;
import com.loja.gui.AplicacaoUI;
import com.loja.pecas.*;

import javax.swing.*;

// Classe principal do programa
public class Aplicacao {
    /* Método principal (main). Aqui se chama o método createGUI()
        O SwingUtilities.invokeLater tem que ser utilizado pois faz parte de como o Swing (ferramenta do java para trabalhar com GUIs) funciona
        Ele faz todo o código ser executado em uma thread específica para fazer os eventos funcionarem
        OBS: O código que está comentado é o trabalho sem a utilização de interface. Para tal, é necessário descomentar e comentar o
        SwingUtilities.invokeLater.
    */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });

        /* Mostra um MENU por meio de CLI e pede o usuário para escolher opções, como alterar, salvar, excluir a peça, etc
            Dentro de cada case do switch é uma opção que o usuário escolheu. Ai são feitas as devidas manipulações para o processo funcionar
        */
        /*
        Scanner scanner = new Scanner(System.in);

        List<Peca> pecas = new ArrayList<Peca>();
        int op = 0, numPeca;

        try {
            while (op != 7) {
                mostrarMenu();
                System.out.print("Digite uma opção: ");
                op = scanner.nextInt();
                while (op <= 0 || op >= 8) {
                    System.out.print("Opção incorreta, digite novamente: ");
                    op = scanner.nextInt();
                }

                System.out.println();

                switch (op) {
                    case 1:
                        int tipoPeca = 0;
                        mostrarMenuPecas();
                        System.out.println("Digite o tipo da peça ou 0 para sair: ");
                        tipoPeca = scanner.nextInt();
                        while (tipoPeca < 0 || tipoPeca > TipoPeca.values().length) {
                            System.out.println("Tipo inválido, digite novamente ou 0 para sair: ");
                            tipoPeca = scanner.nextInt();
                        }
                        if (tipoPeca == 0)
                            break;

                        adicionarPeca(pecas, tipoPeca);

                        break;
                    case 2:
                        if (pecas.size() == 0) {
                            System.out.println("Não há nenhuma peça");
                            break;
                        }

                        System.out.println("Digite o número da peça para remover ou 0 para sair (consulte as peças para saber seu número): ");
                        numPeca = scanner.nextInt();
                        while (numPeca > pecas.size() || numPeca < 0) {
                            System.out.println("Número inválido, digite novamente ou 0 para sair: ");
                            numPeca = scanner.nextInt();
                        }
                        if (numPeca == 0)
                            break;
                        removerPeca(numPeca, pecas);
                        break;
                    case 3:
                        if (pecas.size() == 0) {
                            System.out.println("Não há nenhuma peça");
                            break;
                        }

                        System.out.println("Digite o número da peça para alterar ou 0 para sair (consulte as peças para saber seu número): ");
                        numPeca = scanner.nextInt();
                        while (numPeca > pecas.size() || numPeca < 0) {
                            System.out.println("Número inválido, digite novamente ou 0 para sair: ");
                            numPeca = scanner.nextInt();
                        }
                        if (numPeca == 0)
                            break;
                        alterarPeca(numPeca, pecas);
                    case 4:
                        verPecas(pecas);
                        break;
                    case 5:
                        totalUnitario(pecas);
                        break;
                    case 6:
                        total(pecas);
                        break;
                    default:
                        break;
                }

                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Programa finalizado com sucesso!");
        */
    }

    // Cria a interface principal e faz as alterações necessárias, como o tamanho mínimo da tela, para fechar ao clicar no X, etc
    private static void createGUI() {
        AplicacaoUI aplicacaoUI = new AplicacaoUI();
        JPanel rootAplicacaoUI = aplicacaoUI.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(rootAplicacaoUI);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(900, 600));
        frame.setVisible(true);
    }

    // Mostra o Menu para o usuário
    private static void mostrarMenu() {
        System.out.println("------------------ MENU ------------------");
        System.out.println("[1] Adicionar Peça");
        System.out.println("[2] Remover Peça");
        System.out.println("[3] Alterar Peça");
        System.out.println("[4] Ver Peças");
        System.out.println("[5] Valor total de cada peça");
        System.out.println("[6] Valor total de todas as peças");
        System.out.println("[7] Sair");
    }

    // Mostra os tipos de peças possíveis para o usuário
    private static void mostrarMenuPecas() {
        int i = 1;
        for (TipoPeca tipoPeca : TipoPeca.values()) {
            System.out.println("[" + i + "] " + tipoPeca);
            i++;
        }
    }

    // Adiciona a peça na lista de peças. Para tal, pede os dados para o usuário digitar
    private static void adicionarPeca(List<Peca> pecas, int tipoPeca) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            TipoPeca enumTipoPeca = TipoPeca.valueOf(TipoPeca.values()[tipoPeca - 1].toString());
            String nome, marca, dRam, videoIntegrado;
            int armazenamento, velocidade, tipoHd, estoque, qtdUsb, qtdHd, slotsExpansao, memoriaPV, cores, threads;
            int i = 1;
            float valor;

            System.out.print("Nome: ");
            nome = scanner.nextLine();

            System.out.print("Marca: ");
            marca = scanner.nextLine();

            System.out.print("Estoque: ");
            estoque = scanner.nextInt();
            while (estoque < 0) {
                System.out.print("Estoque inválido, digite novamente: ");
                estoque = scanner.nextInt();
            }

            System.out.print("Valor: ");
            valor = scanner.nextFloat();
            while (valor <= 0) {
                System.out.print("Valor inválido, digite novamente: ");
                valor = scanner.nextFloat();
            }

            switch (enumTipoPeca) {
                case HD:
                    Hd hd = new Hd(nome, marca, estoque, valor, enumTipoPeca);

                    System.out.print("Armazenamento: ");
                    armazenamento = scanner.nextInt();
                    while (armazenamento < 0) {
                        System.out.print("Armazenamento inválido, digite novamente: ");
                        armazenamento = scanner.nextInt();
                    }

                    System.out.print("Velocidade: ");
                    velocidade = scanner.nextInt();
                    while (velocidade < 0) {
                        System.out.print("Velocidade inválida, digite novamente: ");
                        velocidade = scanner.nextInt();
                    }

                    System.out.println("Tipos: ");
                    for (TipoHd t : TipoHd.values()) {
                        System.out.println("[" + i + "] " + t);
                        i++;
                    }
                    System.out.print("Digite um tipo: ");
                    tipoHd = scanner.nextInt();
                    while (tipoHd < 1 || tipoHd > TipoHd.values().length) {
                        System.out.print("Tipo de HD inválido, digite novamente: ");
                        tipoHd = scanner.nextInt();
                    }

                    hd.setArmazenamento(armazenamento);
                    hd.setVelocidade(velocidade);
                    hd.setTipoHd(TipoHd.valueOf(TipoHd.values()[tipoHd - 1].toString()));
                    pecas.add(hd);
                    break;
                case MEMORIA:
                    Memoria memoria = new Memoria(nome, marca, estoque, valor, enumTipoPeca);

                    System.out.print("Armazenamento: ");
                    armazenamento = scanner.nextInt();
                    while (armazenamento < 0) {
                        System.out.print("Armazenamento inválido, digite novamente: ");
                        armazenamento = scanner.nextInt();
                    }

                    System.out.print("Velocidade: ");
                    velocidade = scanner.nextInt();
                    while (velocidade < 0) {
                        System.out.print("Velocidade inválida, digite novamente: ");
                        velocidade = scanner.nextInt();
                    }

                    memoria.setArmazenamento(armazenamento);
                    memoria.setVelocidade(velocidade);
                    pecas.add(memoria);
                    break;
                case PLACAMAE:
                    PlacaMae placaMae = new PlacaMae(nome, marca, estoque, valor, enumTipoPeca);

                    System.out.print("Quantidades de USBs: ");
                    qtdUsb = scanner.nextInt();
                    while (qtdUsb < 0) {
                        System.out.print("Quantidade de USBs inválida, digite novamente: ");
                        qtdUsb = scanner.nextInt();
                    }

                    System.out.print("Quantidade de suportes para HDs: ");
                    qtdHd = scanner.nextInt();
                    while (qtdHd < 0) {
                        System.out.print("Quantidade de suportes para HDs inválida, digite novamente: ");
                        qtdHd = scanner.nextInt();
                    }

                    System.out.print("Quantidade de slots de expansão: ");
                    slotsExpansao = scanner.nextInt();
                    while (slotsExpansao < 0) {
                        System.out.print("Quantidade de slots de expansão inválida, digite novamente: ");
                        slotsExpansao = scanner.nextInt();
                    }

                    placaMae.setQtdUsb(qtdUsb);
                    placaMae.setQtdHd(qtdHd);
                    placaMae.setSlotsExpansao(slotsExpansao);
                    pecas.add(placaMae);
                    break;
                case PLACAVIDEO:
                    PlacaVideo placaVideo = new PlacaVideo(nome, marca, estoque, valor, enumTipoPeca);

                    System.out.print("Memória: ");
                    memoriaPV = scanner.nextInt();
                    while (memoriaPV < 0) {
                        System.out.print("Memória inválida, digite novamente: ");
                        memoriaPV = scanner.nextInt();
                    }

                    System.out.print("DRAM: ");
                    dRam = scanner.nextLine();

                    placaVideo.setMemoria(memoriaPV);
                    placaVideo.setdRam(dRam);
                    pecas.add(placaVideo);
                    break;
                case PROCESSADOR:
                    Processador processador = new Processador(nome, marca, estoque, valor, enumTipoPeca);

                    System.out.print("Velocidade: ");
                    velocidade = scanner.nextInt();
                    while (velocidade < 0) {
                        System.out.print("Velocidade inválida, digite novamente: ");
                        velocidade = scanner.nextInt();
                    }

                    System.out.print("Cores: ");
                    cores = scanner.nextInt();
                    while (cores < 0) {
                        System.out.print("Cores inválida, digite novamente: ");
                        cores = scanner.nextInt();
                    }

                    System.out.print("Threads: ");
                    threads = scanner.nextInt();
                    while (threads < 0) {
                        System.out.print("Threads inválida, digite novamente: ");
                        threads = scanner.nextInt();
                    }

                    System.out.print("Vídeo integrado: ");
                    videoIntegrado = scanner.nextLine();
                    pecas.add(processador);
                    break;
                default:
                    Peca peca = new Peca(nome, marca, estoque, valor, enumTipoPeca);
                    pecas.add(peca);
                    break;
            }
        } catch(Exception e) {
            System.out.println("Houve um erro ao adicionar peça");
        }
    }


    // Remove a peça escolhida da lista de peças
    private static void removerPeca(int num, List<Peca> pecas) throws Exception{
        try {
            pecas.remove(num - 1);
        } catch (Exception e) {
            System.out.println("Houve um erro ao  remover peça");
        }
    }

    // Altera a peça que foi escolhida e a modifica na lista de peças
    private static void alterarPeca(int num, List<Peca> pecas) {
        Scanner scanner = new Scanner(System.in);
        Peca peca = pecas.get(num - 1);
        String nome, marca, op, dRam, videoIntegrado;
        int estoque, armazenamento, i, tipoHd, qtdUsb, qtdHd, slotsExpansao, memoriaPV, cores, threads;
        float valor, velocidade;
        TipoPeca tipoPeca;

        System.out.println("Digite S para sim ou N para não para alterar os valores");

        System.out.print("Alterar nome: ");
        op = scanner.nextLine().toUpperCase();
        op = verificaOpcao(op);
        if ("S".equals(op)) {
            System.out.println("Nome: ");
            nome = scanner.nextLine();
            peca.setNome(nome);
        }

        System.out.print("Alterar marca: ");
        op = scanner.nextLine().toUpperCase();
        op = verificaOpcao(op);
        if ("S".equals(op)) {
            System.out.println("Marca:");
            marca = scanner.nextLine();
            peca.setMarca(marca);
        }

        System.out.print("Alterar estoque: ");
        op = scanner.nextLine().toUpperCase();
        op = verificaOpcao(op);
        if ("S".equals(op)) {
            System.out.print("Estoque: ");
            estoque = scanner.nextInt();
            while (estoque < 0) {
                System.out.print("Estoque inválido, digite novamente: ");
                estoque = scanner.nextInt();
            }
            peca.setEstoque(estoque);
        }

        System.out.print("Alterar valor: ");
        op = scanner.nextLine().toUpperCase();
        op = verificaOpcao(op);
        if ("S".equals(op)) {
            System.out.print("Valor: ");
            valor = scanner.nextFloat();
            while (valor <= 0) {
                System.out.print("Valor inválido, digite novamente: ");
                valor = scanner.nextFloat();
            }
            peca.setValor(valor);
        }

        switch (peca.getTipoPeca()) {
            case HD:
                Hd hd = (Hd) peca;

                System.out.print("Alterar armazenamento: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Armazenamento: ");
                    armazenamento = scanner.nextInt();
                    while (armazenamento < 0) {
                        System.out.print("Armazenamento inválido, digite novamente: ");
                        armazenamento = scanner.nextInt();
                    }
                    hd.setArmazenamento(armazenamento);
                }

                System.out.print("Alterar tipo: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Tipos: ");
                    i = 1;
                    for (TipoHd t : TipoHd.values()) {
                        System.out.print("[" + i + "] " + t);
                        i++;
                    }
                    System.out.print("Digite um tipo:");
                    tipoHd = scanner.nextInt();
                    while (tipoHd < 1 || tipoHd > TipoHd.values().length) {
                        System.out.print("Tipo de HD inválido, digite novamente: ");
                        tipoHd = scanner.nextInt();
                    }
                    hd.setTipoHd(TipoHd.valueOf(TipoHd.values()[tipoHd - 1].toString()));
                }
                break;
            case MEMORIA:
                Memoria memoria = (Memoria) peca;

                System.out.print("Alterar armazenamento: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Armazenamento: ");
                    armazenamento = scanner.nextInt();
                    while (armazenamento < 0) {
                        System.out.print("Armazenamento inválido, digite novamente: ");
                        armazenamento = scanner.nextInt();
                    }
                    memoria.setArmazenamento(armazenamento);
                }

                System.out.print("Alterar velocidade: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    velocidade = scanner.nextInt();
                    while (velocidade < 0) {
                        System.out.print("Velocidade inválida, digite novamente: ");
                        velocidade = scanner.nextInt();
                    }
                    memoria.setVelocidade(velocidade);
                }
                break;
            case PLACAMAE:
                PlacaMae placaMae = (PlacaMae) peca;

                System.out.print("Alterar Quantidade de USBs: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Quantidades de USBs: ");
                    qtdUsb = scanner.nextInt();
                    while (qtdUsb < 0) {
                        System.out.print("Quantidade de USBs inválida, digite novamente: ");
                        qtdUsb = scanner.nextInt();
                    }
                    placaMae.setQtdUsb(qtdUsb);
                }

                System.out.print("Alterar Quantidade de suporte de HDs: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Quantidade de suportes para HDs: ");
                    qtdHd = scanner.nextInt();
                    while (qtdHd < 0) {
                        System.out.print("Quantidade de suportes para HDs inválida, digite novamente: ");
                        qtdHd = scanner.nextInt();
                    }
                    placaMae.setQtdHd(qtdHd);
                }

                System.out.print("Alterar quantidade de slots de expansão: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Quantidade de slots de expansão: ");
                    slotsExpansao = scanner.nextInt();
                    while (slotsExpansao < 0) {
                        System.out.print("Quantidade de slots de expansão inválida, digite novamente: ");
                        slotsExpansao = scanner.nextInt();
                    }
                    placaMae.setSlotsExpansao(slotsExpansao);
                }
                break;
            case PLACAVIDEO:
                PlacaVideo placaVideo = (PlacaVideo) peca;

                System.out.print("Alterar Memória: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Memória: ");
                    memoriaPV = scanner.nextInt();
                    while (memoriaPV < 0) {
                        System.out.print("Memória inválida, digite novamente: ");
                        memoriaPV = scanner.nextInt();
                    }
                    placaVideo.setMemoria(memoriaPV);
                }

                System.out.print("Alterar quantidade de slots de expansão: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("DRAM: ");
                    dRam = scanner.nextLine();
                    placaVideo.setdRam(dRam);
                }
                break;
            case PROCESSADOR:
                Processador processador = (Processador) peca;

                System.out.print("Alterar Velocidade: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Velocidade: ");
                    velocidade = scanner.nextInt();
                    while (velocidade < 0) {
                        System.out.print("Velocidade inválida, digite novamente: ");
                        velocidade = scanner.nextInt();
                    }
                    processador.setVelocidade(velocidade);
                }

                System.out.print("Alterar Cores: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Cores: ");
                    cores = scanner.nextInt();
                    while (cores < 0) {
                        System.out.print("Cores inválida, digite novamente: ");
                        cores = scanner.nextInt();
                    }
                    processador.setCores(cores);
                }

                System.out.print("Alterar Threads: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Threads: ");
                    threads = scanner.nextInt();
                    while (threads < 0) {
                        System.out.print("Threads inválida, digite novamente: ");
                        threads = scanner.nextInt();
                    }
                    processador.setThreads(threads);
                }

                System.out.print("Alterar Vídeo integrado: ");
                op = scanner.nextLine().toUpperCase();
                op = verificaOpcao(op);
                if ("S".equals(op)) {
                    System.out.print("Vídeo integrado: ");
                    videoIntegrado = scanner.nextLine();
                    processador.setVideoIntegrado(videoIntegrado);
                }
                break;
            default:
                break;
        }

    }

    // Verifica se a opção que o usuário escolheu é válida (S para Sim ou N para Não)
    private static String verificaOpcao(String op) {
        Scanner scanner = new Scanner(System.in);
        while (!"S".equals(op) && !"N".equals(op)) {
            System.out.print("Opção inválida, digite novamente: ");
            op = scanner.nextLine().toUpperCase();
        }
        return op;
    }

    // Mostra todos os dados das peças na lista de peças
    private static void verPecas(List<Peca> pecas) {
        if (pecas.size() == 0)
            System.out.println("Não há nenhuma peça registrada");

        int i = 1;

        for (Peca peca: pecas) {
            System.out.println("Peça " + i);
            System.out.println("Nome: " + peca.getNome());
            System.out.println("Marca: " + peca.getMarca());
            System.out.println("Estoque: " + peca.getEstoque());
            System.out.println("Valor: R$" + peca.getValor());
            System.out.println("Tipo: " + peca.getTipoPeca().getValor());

            switch(peca.getTipoPeca()) {
                case HD:
                    Hd hd = (Hd) peca;
                    System.out.println("Armazenamento: " + hd.getArmazenamento() + "GB");
                    System.out.println("Velocidade: " + hd.getVelocidade() + "MBs");
                    System.out.println("Tipo do HD: " + hd.getTipoHd().getValor());
                    break;
                case MEMORIA:
                    Memoria memoria = (Memoria) peca;
                    System.out.println("Armazenamento: " + memoria.getArmazenamento() + "GB");
                    System.out.println("Velocidade: " + memoria.getVelocidade() + "MHz");
                    break;
                case PLACAMAE:
                    PlacaMae placaMae = (PlacaMae) peca;
                    System.out.println("Quantidade de Portas USB: " + placaMae.getQtdUsb());
                    System.out.println("Suportes para HDs: " + placaMae.getQtdHd());
                    System.out.println("Slots de expansão: " + placaMae.getSlotsExpansao());
                    break;
                case PLACAVIDEO:
                    PlacaVideo placaVideo = (PlacaVideo) peca;
                    System.out.println("Memória: " + placaVideo.getMemoria() + "GB");
                    System.out.println("DRAM: " + placaVideo.getdRam());
                    break;
                case PROCESSADOR:
                    Processador processador = (Processador) peca;
                    System.out.println("Velocidade: " + processador.getVelocidade() + "GHz");
                    System.out.println("Cores: " + processador.getCores());
                    System.out.println("Threads: " + processador.getThreads());
                    System.out.println("Vídeo Integrado: " + processador.getVideoIntegrado());
                    break;
                default:
                    break;
            }
            System.out.println();
            i++;
        }
    }

    // Mostra o total unitário de cada peça na lista de peças (Valor * Estoque)
    private static void totalUnitario(List<Peca> pecas) {
        if (pecas.size() == 0) {
            System.out.println("Não há nenhuma peça");
            return;
        }

        for (Peca peca: pecas) {
            System.out.println("Nome: " + peca.getNome());
            System.out.println("Total: R$" + (peca.getValor() * peca.getEstoque()));
            System.out.println();
        }
    }

    // Mostra o total geral de todas as peças da lista de peças
    private static void total(List<Peca> pecas) {
        if (pecas.size() == 0) {
            System.out.println("Não há nenhuma peça");
            return;
        }

        float total = (float) pecas.stream().mapToDouble(p -> p.getValor() * p.getEstoque()).sum();
        System.out.println("Total: R$" + total);
    }
}