package com.meli.loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {
    private List<Cliente> clientes;

    public Database() {
        this.clientes = new ArrayList<Cliente>();
    }

    public Cliente getClienteById(int id){
        return this.clientes.stream().filter(cliente -> cliente.getId() == id).findFirst().orElse(null);
    }

    public boolean saveCliente(Cliente cliente){
        return this.clientes.add(cliente);
    }

    public boolean savePedido(Pedido pedido, int clienteId){
        return this.clientes.stream().filter(cliente -> cliente.getId() == clienteId).findFirst().orElse(null).addPedido(pedido);
    }
}
