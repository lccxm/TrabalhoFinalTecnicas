package com.GustavoLuccaNicolas.bookStore.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private double preco;
    private String autor;
    private String titulo;
    private String descricao;
    private boolean disponivel;
    private Genero genero;
    private int nVendas;

    protected Livro(){}
    
    public Livro(double preco, String autor, String titulo, String descricao, long id, Genero genero){
        this.preco = preco;
        this.autor = autor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.id = id;
        this.genero = genero;
        disponivel = true;
        nVendas = 0;
    }

    public int getnVendas(){ return nVendas; }

    public void vender(){ nVendas++; }

    public double getPreco(){
        return preco;
    }

    public String getAutor(){
        return autor;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public long getId(){
        return id;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public Genero getGenero(){
        return genero;
    }

    public void setDisponivel(boolean b){
        disponivel = b;
    }

    public void setPreco(double p){
        preco = p;
    }



}
