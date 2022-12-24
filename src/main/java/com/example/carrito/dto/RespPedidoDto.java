package com.example.carrito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPedidoDto {
    private PedidoDto pedido;
    private String mensaje;
}
