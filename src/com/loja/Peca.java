package com.loja;

public class Peca {
    private String nome;
    private String marca;
    private int estoque;
    private float valor;
    private TipoPeca tipoPeca;
    private String descricao;           // Apenas para uso na inferface. No trabalho sem interface esse campo não é usado, no lugar é usado as classes de Tipos de Peças Específicos

    public Peca() {};

    public Peca(String nome) {
        this.nome = nome;
    }

    public Peca(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
    }

    public Peca(String nome, String marca, int estoque) {
        this.nome = nome;
        this.marca = marca;
        this.estoque = estoque;
    }

    public Peca(String nome, String marca, int estoque, float valor) {
        this.nome = nome;
        this.marca = marca;
        this.estoque = estoque;
        this.valor = valor;
    }

    public Peca(String nome, String marca, int estoque, float valor, TipoPeca tipoPeca) {
        this.nome = nome;
        this.marca = marca;
        this.estoque = estoque;
        this.valor = valor;
        this.tipoPeca = tipoPeca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoPeca getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(TipoPeca tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
