package com.example.carrito.servicios;

import com.example.carrito.dto.MarcaDto;
import com.example.carrito.dto.ProductoDto;
import com.example.carrito.dto.RespMarcaDto;
import com.example.carrito.dto.RespProductoDto;

import java.util.List;

public interface IProductoServicio {
    public RespProductoDto agregar(ProductoDto productoDto);
    public RespProductoDto eliminar(Long id);
    public List<ProductoDto> listar();
    public RespProductoDto obtener(Long id);
}
