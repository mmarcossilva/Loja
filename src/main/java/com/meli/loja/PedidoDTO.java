package com.meli.loja;

import java.util.List;

public class PedidoDTO {
    private List<Produto> produtos;
    private double valorTotal;

    public PedidoDTO(Pedido pedido) {
        this.produtos = pedido.getProdutos();
        this.valorTotal = pedido.getValorTotal();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
