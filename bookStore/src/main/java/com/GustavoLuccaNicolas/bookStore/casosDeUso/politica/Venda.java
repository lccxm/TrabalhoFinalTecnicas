package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

import com.GustavoLuccaNicolas.bookStore.entidades.Cliente;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String cupomStr;
    private Cliente cliente;
    private List<Livro> livros;

    protected Venda(){}

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.livros = new LinkedList<>();
    }

    public double getDesconto(){
        return CupomFactory.getCupom(cupomStr, this).getDesconto();
    }

    public Double getFrete() {
        return Frete.getFrete(cliente.getUf());
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String getCupomStr(){ return this.cupomStr; }

    public List<Livro> getLivros(){ return this.livros; }

    public Double getSubTotal() {
        Double total = 0.00;
        for (Livro livro : livros)
            total += livro.getPreco();
        return total;
    }

    public Double getValorFinal() {
        return this.getSubTotal() - this.getDesconto() + this.getFrete();
    }

    public void addCupom(String cupomStr){
        this.cupomStr = cupomStr;
    }

    public void addLivro(Livro livro){
        livros.add(livro);
    }

    public void removeLivro(Livro livro){
        livros.remove(livro);
    }
}
