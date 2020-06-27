package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

public abstract class Cupom {
    protected Venda venda;

    public Cupom(Venda venda) {
        this.venda = venda;
    }

    public abstract double getDesconto();

}