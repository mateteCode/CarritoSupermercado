package com.example.carrito.repositorios;

import com.example.carrito.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
