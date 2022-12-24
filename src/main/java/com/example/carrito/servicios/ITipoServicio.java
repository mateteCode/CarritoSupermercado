package com.example.carrito.servicios;

import com.example.carrito.dto.CategoriaDto;
import com.example.carrito.dto.RespCategoriaDto;
import com.example.carrito.dto.RespTipoDto;
import com.example.carrito.dto.TipoDto;

import java.util.List;

public interface ITipoServicio {
    public RespTipoDto agregar(TipoDto tipoDto);
    public RespTipoDto eliminar(Long id);
    public List<TipoDto> listar();
    public RespTipoDto obtener(Long id);
}
