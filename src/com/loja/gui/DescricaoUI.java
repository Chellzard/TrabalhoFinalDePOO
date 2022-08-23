package com.loja.gui;

import com.loja.Peca;

import javax.swing.*;

public class DescricaoUI {

    private JLabel labelNomePeca;
    private JPanel rootPanel;
    private JLabel labelDescricao;

    DescricaoUI(Peca peca) {
        labelNomePeca.setText(peca.getNome());
        labelDescricao.setText(peca.getDescricao());
    }
    public JPanel getRootPanel() {
        return rootPanel;
    }
}
