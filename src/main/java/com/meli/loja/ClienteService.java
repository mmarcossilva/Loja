package com.meli.loja;

import java.util.List;

public class ClienteService {
    private Database database;

    public ClienteService() {
        this.database = new Database();
    }

    public boolean insertCliente(Cliente cliente){
        return database.saveCliente(cliente);
    }

    public boolean insertPedido(Pedido pedido, int id){
        return database.savePedido(pedido, id);
    }

    public List<Pedido> getPedidos(int id) {
        return database.getClienteById(id).getPedidos();
    }
}
