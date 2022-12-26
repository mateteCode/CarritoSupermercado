package com.example.carrito.servicios;

import com.example.carrito.dto.PedidoDto;
import com.example.carrito.dto.PedidoDtoCarrito;
import com.example.carrito.dto.RespPedidoDto;
import com.example.carrito.entidades.Carrito;

import java.util.List;

public interface IPedidoServicio {
    public RespPedidoDto agregar(PedidoDto pedidoDto);
    public RespPedidoDto eliminar(Long id);
    public List<PedidoDto> listar();
    public RespPedidoDto obtener(Long id);

    public List<PedidoDtoCarrito> listarPorCarrito(Carrito carrito);
}
