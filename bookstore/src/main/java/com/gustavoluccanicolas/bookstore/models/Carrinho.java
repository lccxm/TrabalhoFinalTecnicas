package com.gustavoluccanicolas.bookstore.models;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho {

    @ManyToMany
    private List<Livro> livros;
    @ManyToOne
    private Cliente cliente;

    private double total;

    protected Carrinho(){
    }

    public Carrinho(Cliente cliente){
        this.cliente = cliente;
        total = 0;
        livros = new ArrayList<>();
    }

    public void addLivro(Livro livro){
        livros.add(livro);
    }

    public void removeLivro(Livro livro){
        livros.remove(livro);
    }

    public double getTotal(){
        for(Livro livro : livros){
            total += livro.getPreco();
        }
        return total;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public List<Livro> getLivros(){
        return livros;
    }
}
