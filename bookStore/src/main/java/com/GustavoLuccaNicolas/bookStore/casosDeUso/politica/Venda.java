package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

import com.GustavoLuccaNicolas.bookStore.entidades.Pedido;

public class Venda {
    private String cupomStr;
    private Pedido pedido;



    public Venda(String cupomStr, Pedido pedido) {
        this.cupomStr = cupomStr;
        this.pedido = pedido;
    }

    public String getCupom() {
        return this.cupom;
    }

    public double getDesconto(){
        return CupomFactory.getCupom(cupomStr).getDesconto();
    }

    public Double getFrete() {
        return Frete.getFrete(pedido.getCliente().getUf());
    }

    public Pedido getPedido() {
        return this.pedido;
    }


    public Double getSubTotal() {
        return pedido.getSubTotal();
    }

    public Double getValorFinal() {
        return this.valorFinal;
    }

}
