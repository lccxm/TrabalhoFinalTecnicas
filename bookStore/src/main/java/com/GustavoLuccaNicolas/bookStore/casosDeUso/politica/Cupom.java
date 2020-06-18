package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

public abstract class Cupom {
    private String cupomStr;
    private double desconto;


    public Cupom(String cupomStr, Venda venda) {
        this.cupomStr = cupomStr;
        this.desconto = getDesconto();
    }


    public String getCupomStr() {
        return this.cupomStr;
    }

    public abstract double getDesconto();

}