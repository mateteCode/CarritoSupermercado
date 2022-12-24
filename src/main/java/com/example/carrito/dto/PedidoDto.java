package com.example.carrito.dto;

import com.example.carrito.entidades.Carrito;
import com.example.carrito.entidades.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private Long id;
    private Integer cantidad;
    private Carrito carrito;
    private Producto producto;
}
