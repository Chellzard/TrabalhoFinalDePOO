package com.loja.pecas;

import com.loja.Peca;
import com.loja.TipoPeca;
import com.loja.pecas.TipoHd;

public class Hd extends Peca {
    private int armazenamento;
    private int velocidade;

    private TipoHd tipoHd;

    public Hd() {};

    public Hd(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca) {
        super(nome, marca, estoque, valor, tipoPeca);
    }

    public Hd(String nome, String marca, int estoque, float valor, int armazenamento) {
        super(nome, marca, estoque, valor);
        this.armazenamento = armazenamento;
    }

    public Hd(String nome, String marca, int estoque, float valor, int armazenamento, int velocidade) {
        super(nome, marca, estoque, valor);
        this.armazenamento = armazenamento;
        this.velocidade = velocidade;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public TipoHd getTipoHd() {
        return tipoHd;
    }

    public void setTipoHd(TipoHd tipoHd) {
        this.tipoHd = tipoHd;
    }
}
