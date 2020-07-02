package com.gustavoluccanicolas.bookstore.casosdeuso.repositories.services.utils;

import com.gustavoluccanicolas.bookstore.entidades.Livro;
import com.gustavoluccanicolas.bookstore.entidades.Venda;
import com.gustavoluccanicolas.bookstore.entidades.enums.Genero;

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
