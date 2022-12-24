package com.example.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespCategoriaDto {
    private CategoriaDto categoria;
    private String mensaje;
}
