package com.loja.pecas;

import com.loja.Peca;
import com.loja.TipoPeca;

// Objeto PlacaMae. Aqui se usa: Herança, Encapsulamento e Sobrecarga
public class PlacaMae extends Peca {
    private int qtdUsb;
    private int qtdHd;
    private int slotsExpansao;

    public PlacaMae() {};

    public PlacaMae(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca) {
        super(nome, marca, estoque, valor, tipoPeca);
    }

    public PlacaMae(String nome, String marca, int estoque, float valor, int qtdUsb) {
        super(nome, marca, estoque, valor);
        this.qtdUsb = qtdUsb;
    }

    public PlacaMae(String nome, String marca, int estoque, float valor, int qtdUsb, int qtdHd) {
        super(nome, marca, estoque, valor);
        this.qtdUsb = qtdUsb;
        this.qtdHd = qtdHd;
    }

    public PlacaMae(String nome, String marca, int estoque, float valor, int qtdUsb, int qtdHd, int slotsExpansao) {
        super(nome, marca, estoque, valor);
        this.qtdUsb = qtdUsb;
        this.qtdHd = qtdHd;
        this.slotsExpansao = slotsExpansao;
    }

    public int getQtdUsb() {
        return qtdUsb;
    }

    public void setQtdUsb(int qtdUsb) {
        this.qtdUsb = qtdUsb;
    }

    public int getQtdHd() {
        return qtdHd;
    }

    public void setQtdHd(int qtdHd) {
        this.qtdHd = qtdHd;
    }

    public int getSlotsExpansao() {
        return slotsExpansao;
    }

    public void setSlotsExpansao(int slotsExpansao) {
        this.slotsExpansao = slotsExpansao;
    }
}
