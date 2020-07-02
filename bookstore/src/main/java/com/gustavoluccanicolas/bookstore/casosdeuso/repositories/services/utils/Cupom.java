package com.gustavoluccanicolas.bookstore.casosdeuso.repositories.services.utils;

import com.gustavoluccanicolas.bookstore.entidades.Venda;

public abstract class Cupom {
    protected Venda venda;

    public Cupom(Venda venda) {
        this.venda = venda;
    }

    public abstract double getDesconto();

}
