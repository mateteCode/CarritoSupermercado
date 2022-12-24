package com.example.carrito.servicios;

import com.example.carrito.dto.PedidoDto;
import com.example.carrito.dto.RespPedidoDto;

import java.util.List;

public interface IPedidoServicio {
    public RespPedidoDto agregar(PedidoDto pedidoDto);
    public RespPedidoDto eliminar(Long id);
    public List<PedidoDto> listar();
    public RespPedidoDto obtener(Long id);
}
