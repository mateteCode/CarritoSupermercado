package com.example.carrito.repositorios;

import com.example.carrito.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepositorio extends JpaRepository<Producto, Long> {
}
