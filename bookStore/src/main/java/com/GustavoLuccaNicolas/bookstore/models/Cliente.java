package com.gustavoluccanicolas.bookStore.models;

import javax.persistence.Entity;

@Entity
public class Cliente extends EntidadeBase{

    public static final String CPF_REGEXP = "[\\d]{3}\\.?[\\d]{3}\\.?[\\d]{3}\\-?[\\d]{2}";
    public static final String CPF_REGEXP_EXACT = "^" + CPF_REGEXP + "$";

    private String cpf;
    private String nome;
    private String formaPagamento;
    private String endereco;
    private String uf;

    protected Cliente() {
    }

    public Cliente(String cpf, String nome, String formaPagamento, String endereco, String uf) {
        this.cpf = cpf;
        this.nome = nome;
        this.formaPagamento = formaPagamento;
        this.endereco = endereco;
        this.uf = uf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getUf() {
        return this.uf;
    }
}
