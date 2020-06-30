package com.gustavoluccanicolas.bookstore.services.utils;

import com.gustavoluccanicolas.bookstore.models.Venda;

public class CupomQuantidade extends Cupom {
    private final double DESCONTO = 0.15;

    public CupomQuantidade(Venda venda){
        super(venda);
    }

    @Override
    public double getDesconto(){
        if (venda.getLivros().size()>=3)
            return venda.getSubTotal() * DESCONTO;
        else
            throw new IllegalArgumentException("Voce precisa ter pelo menos 3 itens em seu carrinho para ativar este desconto.");
    }
}
