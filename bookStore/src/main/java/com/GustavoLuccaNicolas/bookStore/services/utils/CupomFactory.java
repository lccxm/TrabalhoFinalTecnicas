package com.gustavoluccanicolas.bookStore.services.utils;

import com.gustavoluccanicolas.bookStore.models.Venda;

public class CupomFactory {
    public static Cupom getCupom(String cupomStr, Venda venda) {
        switch(cupomStr){
            case "romance10": return new CupomRomance(venda);
            case "3mais": return new CupomQuantidade(venda);
            default: throw new IllegalArgumentException("Cupom invalido.");
        }
    }
}
