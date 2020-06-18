package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

public abstract class Cupom {
    private String cupomStr;
    private double desconto;
    protected Venda venda;

    public Cupom(String cupomStr, Venda venda) {
        this.cupomStr = cupomStr;
        this.desconto = getDesconto();
        this.venda = venda;
    }

    public String getCupomStr() {
        return this.cupomStr;
    }

    public abstract double getDesconto();

}