package com.endpointspi.demo.service;


import com.endpointspi.demo.entity.ItemMenu;
import com.endpointspi.demo.entity.Restaurante;
import com.endpointspi.demo.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante) {
        for (ItemMenu item : restaurante.getItens()) {
            item.setRestaurante(restaurante);
        }
        return restauranteRepository.save(restaurante);
    }

    public List<ItemMenu> listarCardapio(Long restauranteId) {
        return restauranteRepository.findById(restauranteId)
                .map(Restaurante::getItens)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
    }
}

