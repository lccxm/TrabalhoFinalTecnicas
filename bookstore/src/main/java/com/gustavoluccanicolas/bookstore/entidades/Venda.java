package com.gustavoluccanicolas.bookstore.entidades;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.services.utils.CupomFactory;
import com.gustavoluccanicolas.bookstore.casosdeuso.repositories.services.utils.Frete;

@Entity
public class Venda extends EntidadeBase{


    private String cupomStr;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Livro> livros;

    protected Venda() {
    }

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.livros = new LinkedList<>();
    }

    public double getDesconto() {
        return CupomFactory.getCupom(cupomStr, this).getDesconto();
    }

    public Double getFrete() {
        return Frete.getFrete(cliente.getUf());
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String getCupomStr() {
        return this.cupomStr;
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public Double getSubTotal() {
        double total = 0.00;
        for (Livro livro : livros)
            total += livro.getPreco();
        return total;
    }

    public Double getValorFinal() {
        return this.getSubTotal() - this.getDesconto() + this.getFrete();
    }

    public void addCupom(String cupomStr) {
        this.cupomStr = cupomStr;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void removeLivro(Livro livro) {
        livros.remove(livro);
    }
}
