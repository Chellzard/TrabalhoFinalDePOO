package com.loja.pecas;

import com.loja.Peca;
import com.loja.TipoPeca;
import org.omg.CORBA.TIMEOUT;

public class Processador extends Peca {
    private float velocidade;
    private int cores;
    private int threads;
    private String videoIntegrado;

    public Processador() {};

    public Processador(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca) {
        super(nome, marca, estoque, valor, tipoPeca);
    }

    public Processador(String nome, String marca, int estoque, float valor, float velocidade) {
        super(nome, marca, estoque, valor);
        this.velocidade = velocidade;
    }

    public Processador(String nome, String marca, int estoque, float valor, float velocidade, int cores) {
        super(nome, marca, estoque, valor);
        this.velocidade = velocidade;
        this.cores = cores;
    }

    public Processador(String nome, String marca, int estoque, float valor, float velocidade, int cores, int threads) {
        super(nome, marca, estoque, valor);
        this.velocidade = velocidade;
        this.cores = cores;
        this.threads = threads;
    }

    public Processador(String nome, String marca, int estoque, float valor, float velocidade, int cores, int threads, String videoIntegrado) {
        super(nome, marca, estoque, valor);
        this.velocidade = velocidade;
        this.cores = cores;
        this.threads = threads;
        this.videoIntegrado = videoIntegrado;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public String getVideoIntegrado() {
        return videoIntegrado;
    }

    public void setVideoIntegrado(String videoIntegrado) {
        this.videoIntegrado = videoIntegrado;
    }
}
