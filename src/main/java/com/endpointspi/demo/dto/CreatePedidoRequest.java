package com.endpointspi.demo.dto;


import java.util.List;

public class CreatePedidoRequest {

    private Long restauranteId;
    private List<Long> itemMenuIds;
    private String nomeCliente;

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

    public List<Long> getItemMenuIds() {
        return itemMenuIds;
    }

    public void setItemMenuIds(List<Long> itemMenuIds) {
        this.itemMenuIds = itemMenuIds;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
