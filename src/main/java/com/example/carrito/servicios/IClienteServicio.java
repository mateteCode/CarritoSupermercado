package com.example.carrito.servicios;

import com.example.carrito.dto.ClienteDto;
import com.example.carrito.dto.RespClienteDto;

import java.util.List;

public interface IClienteServicio {
    public RespClienteDto agregar(ClienteDto clienteDto);
    public RespClienteDto eliminar(Long id);
    public List<ClienteDto> listar();
    public RespClienteDto obtener(Long id);
}
