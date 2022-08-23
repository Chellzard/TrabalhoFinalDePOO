package com.loja;

// Enum TipoPeca. Este enum serve para guardar os possíveis valores para os campos TipoPeca
public enum TipoPeca {
    GERAL("Peça geral"),
    HD ("HD"),
    MEMORIA ("Memória ram"),
    PLACAMAE ("Placa mãe"),
    PLACAVIDEO ("Placa de vídeo"),
    PROCESSADOR ("Processador");

    private String valor;

    TipoPeca(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
