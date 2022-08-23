package com.loja.pecas;

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
