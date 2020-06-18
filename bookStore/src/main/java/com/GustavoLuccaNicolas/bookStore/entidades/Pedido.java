package com.GustavoLuccaNicolas.bookStore.entidades;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Livro> livros;
    private String cupom;
    private Cliente cliente;
    private Livro livro;
    public Pedido(Cliente cliente, ArrayList<Livro> livros) {
        this.livros = livros;
        this.cliente = cliente;
    }

    public double getSubTotal(){
        double total = 0.00;
        for (Livro l: livros) {
            total+=livro.getPreco();
        }
        return total;
    }

    public String getCupom() {
        return cupom;
    }

    public ArrayList<Livro> getPedidoCliente(Cliente c){
        return livros;
    }


    public Cliente getCliente() {
        return this.cliente;
    }


    public ArrayList<Livro> getLivros() {
        return this.livros;
    }


}
