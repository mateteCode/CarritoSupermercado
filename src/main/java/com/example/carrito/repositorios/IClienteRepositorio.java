package com.example.carrito.repositorios;

import com.example.carrito.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepositorio extends JpaRepository<Cliente, Long> {
}
