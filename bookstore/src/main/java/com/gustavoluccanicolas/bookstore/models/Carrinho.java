package com.gustavoluccanicolas.bookstore.models;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho extends EntidadeBase {

    @OneToMany
    private List<Livro> livros;



    private double total;

    protected Carrinho(){
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


    public List<Livro> getLivros(){
        return livros;
    }
}
