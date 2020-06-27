package com.GustavoLuccaNicolas.bookStore.entidades;

public class Livro{

    private double preco;
    private String autor;
    private String titulo;
    private String descricao;
    private boolean disponivel;
    private long id;
    private Genero genero;
    private int nVendas

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

    public int getnVendas(){
        return nVendas;
    }
    public void vender(){
        nVendas++;
    }

}
