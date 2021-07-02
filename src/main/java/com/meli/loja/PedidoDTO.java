package com.meli.loja;

import java.util.List;

public class PedidoDTO {
    private List<Produto> produtos;
    private double valorTotal;
    private String status;

    public PedidoDTO(Pedido pedido) {
        this.produtos = pedido.getProdutos();
        this.valorTotal = pedido.getValorTotal();
        this.status = pedido.getStatus();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
