package com.example.carrito.repositorios;

import com.example.carrito.entidades.Carrito;
import com.example.carrito.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPedidoRepositorio extends JpaRepository<Pedido, Long> {
    List<Pedido> findAllByCarrito(Carrito carrito);
}
