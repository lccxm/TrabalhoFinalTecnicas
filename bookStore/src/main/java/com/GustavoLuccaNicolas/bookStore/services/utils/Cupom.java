package com.gustavoluccanicolas.bookStore.services.utils;

import com.gustavoluccanicolas.bookStore.models.Venda;

public abstract class Cupom {
    protected Venda venda;

    public Cupom(Venda venda) {
        this.venda = venda;
    }

    public abstract double getDesconto();

}
