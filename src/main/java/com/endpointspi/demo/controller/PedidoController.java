package com.endpointspi.demo.controller;


import com.endpointspi.demo.dto.CreatePedidoRequest;
import com.endpointspi.demo.entity.Pedido;
import com.endpointspi.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody CreatePedidoRequest request) {
        return ResponseEntity.ok(pedidoService.criarPedido(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.ok("Pedido com ID " + id + " foi deletado com sucesso!");
    }


}

