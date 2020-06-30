package com.gustavoluccanicolas.bookstore.casosdeuso.politica;

import com.gustavoluccanicolas.bookstore.models.Venda;

public abstract class Cupom {
    protected Venda venda;

    public Cupom(Venda venda) {
        this.venda = venda;
    }

    public abstract double getDesconto();

}
