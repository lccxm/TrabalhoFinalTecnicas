package com.GustavoLuccaNicolas.bookStore.casosDeUso.politica;

import com.GustavoLuccaNicolas.bookStore.entidades.Pedido;

public class Venda {
    private String cupom;
    private Pedido pedido;
    private Long id;
    private Double subTotal;
    private Double valorFinal;


    public Venda(String cupom, Pedido pedido, Double subTotal, Double valorFinal) {
        this.cupom = cupom;
        this.pedido = pedido;
        this.id = id;
        this.subTotal = subTotal;
        this.valorFinal = valorFinal;
    }

    public String getCupom() {
        return this.cupom;
    }

    public Double getFrete() {
        return Frete.getFrete(pedido.getCliente().getUf());
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public Long getId() {
        return this.id;
    }

    public Double getSubTotal() {
        return this.subTotal;
    }

    public Double getValorFinal() {
        return this.valorFinal;
    }

}
