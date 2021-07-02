package com.meli.loja;

import java.util.List;

public class Pedido {
    private int id;
    private List<Produto> produtos;
    private double valorTotal;
    private String status;

    public Pedido(int id, List<Produto> produtos, double valorTotal, String status) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
