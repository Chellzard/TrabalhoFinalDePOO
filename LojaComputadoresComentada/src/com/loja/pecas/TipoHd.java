package com.loja.pecas;

// Enum TipoHd. Este enum serve para guardar os possíveis valores para os campos TipoHd
public enum TipoHd {
    HDSATA("HD Sata"),
    SSDSATA("SSD Sata"),
    SSDNVME("SSD NVME");

    private String valor;

    TipoHd(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
