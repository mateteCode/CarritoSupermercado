package com.example.carrito.servicios;

import com.example.carrito.dto.MarcaDto;
import com.example.carrito.dto.RespMarcaDto;
import com.example.carrito.entidades.Marca;

import java.util.List;

public interface IMarcaServicio {

    public RespMarcaDto agregar(MarcaDto marcaDto);
    public RespMarcaDto eliminar(Long id);
    public List<MarcaDto> listar();
    public RespMarcaDto obtener(Long id);
}
