package com.meli.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public boolean insertCliente(Cliente cliente){
        return repository.add(cliente);
    }

    public boolean insertPedido(Pedido pedido, int id){
        Cliente cliente = repository.getList().stream().filter(cli -> cli.getId() == id)
                .findFirst().orElse(null);
        cliente.addPedido(pedido);
        return repository.alterPedido(cliente);
    }

    public boolean editPedido(Pedido pedido, int id, int pedidoId){
        Cliente cliente = repository.getList().stream().filter(cli -> cli.getId() == id)
                .findFirst().orElse(null);
        List<Pedido> pedidos = cliente.getPedidos().stream().filter(ped -> ped.getId() != pedidoId).collect(Collectors.toList());
        pedidos.add(pedido);
        cliente.setPedidos(pedidos);
        return repository.alterPedido(cliente);
    }

    public void removePedido(int pedidoId, int cliId){
        Cliente cliente = repository.getList().stream().filter(cli -> cli.getId() == cliId)
                .findFirst().orElse(null);
        List<Pedido> pedidos = cliente.getPedidos().stream().filter(ped -> ped.getId() != pedidoId).collect(Collectors.toList());
        cliente.setPedidos(pedidos);
        repository.alterPedido(cliente);
    }

    public List<Pedido> getPedidos(int id) {
        return repository.getList().stream().filter(cliente -> cliente.getId() == id)
                .findFirst().orElse(null).getPedidos();
    }
}
