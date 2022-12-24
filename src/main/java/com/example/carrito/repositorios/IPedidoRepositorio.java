package com.example.carrito.repositorios;

import com.example.carrito.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepositorio extends JpaRepository<Pedido, Long> {
}
