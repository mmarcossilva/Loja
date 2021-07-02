package com.meli.loja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService service = new ClienteService();

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

    @GetMapping
    @RequestMapping("/{id}/pedidos")
    public ResponseEntity<List<Pedido>> get(@PathVariable int id){

        return new ResponseEntity<>(this.service.getPedidos(id), HttpStatus.OK);
    }
}
