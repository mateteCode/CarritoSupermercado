package com.example.carrito.repositorios;

import com.example.carrito.entidades.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoRepositorio extends JpaRepository<Tipo, Long> {
}
