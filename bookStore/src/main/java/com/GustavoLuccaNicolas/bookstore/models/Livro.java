package com.gustavoluccanicolas.bookStore.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gustavoluccanicolas.bookStore.models.enums.Genero;

@Entity
public class Livro extends EntidadeBase {

    private double preco;
    private String autor;
    private String titulo;
    private String descricao;
    private boolean disponivel;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    private int nVendas;

    protected Livro() {
    }

    public Livro(double preco, String autor, String titulo, String descricao, long id, Genero genero) {
        this.preco = preco;
        this.autor = autor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        disponivel = true;
        nVendas = 0;
    }

    public int getnVendas() {
        return nVendas;
    }

    public void vender() {
        nVendas++;
    }

    public double getPreco() {
        return preco;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setDisponivel(boolean b) {
        disponivel = b;
    }

    public void setPreco(double p) {
        preco = p;
    }


}
