package com.endpointspi.demo.service;


import com.endpointspi.demo.dto.CreatePedidoRequest;
import com.endpointspi.demo.entity.ItemMenu;
import com.endpointspi.demo.entity.Pedido;
import com.endpointspi.demo.entity.Restaurante;
import com.endpointspi.demo.repository.ItemMenuRepository;
import com.endpointspi.demo.repository.PedidoRepository;
import com.endpointspi.demo.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private ItemMenuRepository itemMenuRepository;

    public Pedido criarPedido(CreatePedidoRequest request) {
        Restaurante restaurante = restauranteRepository.findById(request.getRestauranteId())
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

        List<ItemMenu> itens = itemMenuRepository.findAllById(request.getItemMenuIds());

        Pedido pedido = new Pedido();
        pedido.setNomeCliente(request.getNomeCliente());
        pedido.setItens(itens);
        pedido.setRestaurante(restaurante);

        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado com ID: " + id);
        }
        pedidoRepository.deleteById(id);
    }


}
