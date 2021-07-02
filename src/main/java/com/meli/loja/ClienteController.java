package com.meli.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @RequestMapping("/")
    public ResponseEntity<ClienteDTO> insert(@RequestBody Cliente cliente){
        boolean b = this.service.insertCliente(cliente);
        if (b)
            return new ResponseEntity<>(new ClienteDTO(cliente), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    @RequestMapping("/{id}/pedido")
    public ResponseEntity<PedidoDTO> insert(@RequestBody Pedido pedido, @PathVariable int id){
        boolean b = this.service.insertPedido(pedido, id);
        if (b)
            return new ResponseEntity<>(new PedidoDTO(pedido), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/pedido/{pedidoId}/")
    public ResponseEntity<PedidoDTO> put(@RequestBody Pedido pedido, @PathVariable int id, @PathVariable int pedidoId){
        boolean b = this.service.editPedido(pedido, id, pedidoId);
        if (b)
            return new ResponseEntity<>(new PedidoDTO(pedido), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    @RequestMapping("/{id}/pedido/{pedidoId}")
    public ResponseEntity<String> delete(@PathVariable int pedidoId, @PathVariable int id) {
        this.service.removePedido(pedidoId, id);
        return new ResponseEntity<>("pedido deletado", HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}/pedidos")
    public ResponseEntity<List<Pedido>> get(@PathVariable int id){

        return new ResponseEntity<>(this.service.getPedidos(id), HttpStatus.OK);
    }
}
