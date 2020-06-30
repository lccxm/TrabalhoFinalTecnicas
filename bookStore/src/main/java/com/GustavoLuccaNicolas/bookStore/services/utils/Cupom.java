package com.gustavoluccanicolas.bookstore.services.utils;

import com.gustavoluccanicolas.bookstore.models.Venda;

public abstract class Cupom {
    protected Venda venda;

    public Cupom(Venda venda) {
        this.venda = venda;
    }

    public abstract double getDesconto();

}
