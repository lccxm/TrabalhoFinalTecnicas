package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

public abstract class Cupom {
    private double desconto;
    protected Venda venda;

    public Cupom(Venda venda) {
        this.desconto = getDesconto();
        this.venda = venda;
    }

    public abstract double getDesconto();

}