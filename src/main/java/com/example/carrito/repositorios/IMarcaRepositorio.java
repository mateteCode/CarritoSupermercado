package com.example.carrito.repositorios;

import com.example.carrito.entidades.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IMarcaRepositorio extends JpaRepository<Marca, Long> {
}
