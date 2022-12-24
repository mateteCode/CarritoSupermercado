package com.example.carrito.servicios;

import com.example.carrito.dto.CategoriaDto;
import com.example.carrito.dto.MarcaDto;
import com.example.carrito.dto.RespCategoriaDto;
import com.example.carrito.dto.RespMarcaDto;

import java.util.List;

public interface ICategoriaServicio {
    public RespCategoriaDto agregar(CategoriaDto categoriaDto);
    public RespCategoriaDto eliminar(Long id);
    public List<CategoriaDto> listar();
    public RespCategoriaDto obtener(Long id);
}
