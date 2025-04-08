package com.endpointspi.demo.repository;


import com.endpointspi.demo.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}


