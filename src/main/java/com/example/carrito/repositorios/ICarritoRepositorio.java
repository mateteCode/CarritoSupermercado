package com.example.carrito.repositorios;

import com.example.carrito.entidades.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarritoRepositorio extends JpaRepository<Carrito, Long> {
}
