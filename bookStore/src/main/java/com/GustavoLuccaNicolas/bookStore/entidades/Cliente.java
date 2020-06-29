package com.GustavoLuccaNicolas.bookStore.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String cpf;
    private String nome;
    private String formaPagamento;
    private String endereco;
    private String uf;

    protected Cliente (){}

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