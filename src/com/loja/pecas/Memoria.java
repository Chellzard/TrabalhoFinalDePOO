package com.loja.pecas;

import com.loja.Peca;
import com.loja.TipoPeca;

public class Memoria extends Peca {
    private int armazenamento;
    private float velocidade;

    public Memoria() {};

    public Memoria(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca) {
        super(nome, marca, estoque, valor, tipoPeca);
    }

    public Memoria(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca, int armazenamento) {
        super(nome, marca, estoque, valor, tipoPeca);
        this.armazenamento = armazenamento;
    }

    public Memoria(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca, int armazenamento, float velocidade) {
        super(nome, marca, estoque, valor, tipoPeca);
        this.armazenamento = armazenamento;
        this.velocidade = velocidade;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }
}
