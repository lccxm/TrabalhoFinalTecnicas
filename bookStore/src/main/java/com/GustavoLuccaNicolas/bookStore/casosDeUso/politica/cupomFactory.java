package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

public class CupomFactory {
    public static Cupom getCupom(String cupomStr, Venda venda) {
        switch(cupomStr){
            case "romance10": new CupomRomance(cupomStr, venda);
            case "3mais": new CupomQuantidade(cupomStr, venda);
            default throw new IllegalArgumentException("Cupom invalido.")
        }
    }
}