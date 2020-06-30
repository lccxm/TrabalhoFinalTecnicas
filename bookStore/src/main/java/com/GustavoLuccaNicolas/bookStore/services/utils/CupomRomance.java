package com.gustavoluccanicolas.bookStore.services.utils;

import com.gustavoluccanicolas.bookStore.models.Livro;
import com.gustavoluccanicolas.bookStore.models.Venda;
import com.gustavoluccanicolas.bookStore.models.enums.Genero;

public class CupomRomance extends Cupom {
    private final double DESCONTO = 0.10;

    public CupomRomance(Venda venda){
        super(venda);
    }

    @Override
    public double getDesconto(){
        Double desconto = 0.0;
        for (Livro livro: venda.getLivros())
            if (livro.getGenero().equals(Genero.ROMANCE))
                desconto += livro.getPreco()*DESCONTO;
        return desconto;
    }
}
