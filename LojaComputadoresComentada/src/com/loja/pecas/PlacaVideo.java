package com.loja.pecas;

import com.loja.Peca;
import com.loja.TipoPeca;
import org.omg.CORBA.TIMEOUT;

// Objeto PlacaVideo. Aqui se usa: Herança, Encapsulamento e Sobrecarga
public class PlacaVideo extends Peca {
    private int memoria;
    private String dRam;

    public PlacaVideo() {};

    public PlacaVideo(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca) {
        super(nome, marca, estoque, valor, tipoPeca);
    }

    public PlacaVideo(String nome, String marca, int estoque, float valor, int memoria) {
        super(nome, marca, estoque, valor);
        this.memoria = memoria;
    }


    public PlacaVideo(String nome, String marca, int estoque, float valor, int memoria, String dRam) {
        super(nome, marca, estoque, valor);
        this.memoria = memoria;
        this.dRam = dRam;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getdRam() {
        return dRam;
    }

    public void setdRam(String dRam) {
        this.dRam = dRam;
    }
}
