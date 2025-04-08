package com.endpointspi.demo.controller;


import com.endpointspi.demo.entity.ItemMenu;
import com.endpointspi.demo.entity.Restaurante;
import com.endpointspi.demo.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> criarRestaurante(@RequestBody Restaurante restaurante) {
        return ResponseEntity.ok(restauranteService.salvar(restaurante));
    }

    @GetMapping("/{id}/cardapio")
    public ResponseEntity<List<ItemMenu>> listarCardapio(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteService.listarCardapio(id));
    }
}
