package com.example.carrito.servicios;

import com.example.carrito.dto.CarritoDto;
import com.example.carrito.dto.RespCarritoDto;

import java.util.List;

public interface ICarritoServicio {
    public RespCarritoDto agregar(CarritoDto carritoDto);
    public RespCarritoDto eliminar(Long id);
    public List<CarritoDto> listar();
    public RespCarritoDto obtener(Long id);
}
