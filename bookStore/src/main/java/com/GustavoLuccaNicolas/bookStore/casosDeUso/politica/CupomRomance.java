package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

import com.GustavoLuccaNicolas.bookStore.entidades.Genero;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;

public class CupomRomance extends Cupom {
    private final double DESCONTO = 0.10;

    public CupomRomance(Venda venda){
        super(venda);
    }

    @Override
    public double getDesconto(){
        Double desconto = 0.0;
        for (Livro livro: venda.getPedido().getLivros())
            if (livro.getGenero().equals(Genero.Romance))
                desconto += livro.getPreco()*DESCONTO;
        return desconto;
    }
}