package com.example.carrito.servicios;

import com.example.carrito.dto.CarritoDto;
import com.example.carrito.dto.RespCarritoDto;
import com.example.carrito.entidades.Carrito;
import com.example.carrito.repositorios.ICarritoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoServicio implements ICarritoServicio{
    @Autowired
    private ICarritoRepositorio carritoRepositorio;

    @Override
    public RespCarritoDto agregar(CarritoDto carritoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Carrito carrito = modelMapper.map(carritoDto, Carrito.class);
        Carrito carritoPersistido = carritoRepositorio.save(carrito);
        RespCarritoDto resp = new RespCarritoDto();
        resp.setCarrito(modelMapper.map(carritoPersistido, CarritoDto.class));
        resp.setMensaje("Se guardó con éxito...");
        return resp;
    }

    @Override
    public RespCarritoDto eliminar(Long id) {
        RespCarritoDto resp = new RespCarritoDto();
        CarritoDto carritoDto = new CarritoDto();
        Optional<Carrito> carritoOptional = carritoRepositorio.findById(id);
        if(carritoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            carritoDto = mapper.map(carritoOptional.get(), CarritoDto.class);
            carritoRepositorio.deleteById(id);
            resp.setMensaje("El carrito ha sido borrado");
        }
        else {
            resp.setMensaje("No existe ese carrito");
            carritoDto.setId(id);
        }
        resp.setCarrito(carritoDto);
        return resp;
    }

    @Override
    public List<CarritoDto> listar() {
        ModelMapper mapper = new ModelMapper();
        List<Carrito> carritos = carritoRepositorio.findAll();
        List<CarritoDto> carritosDto = new ArrayList<>();
        carritos.stream().forEach(c-> carritosDto.add(mapper.map(c, CarritoDto.class)));
        return carritosDto;
    }

    @Override
    public RespCarritoDto obtener(Long id) {
        RespCarritoDto resp = new RespCarritoDto();
        CarritoDto carritoDto = null;
        Optional<Carrito> carritoOptional = carritoRepositorio.findById(id);
        if(carritoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            carritoDto = mapper.map(carritoOptional.get(), CarritoDto.class);
            resp.setMensaje("El carrito ha sido obtenido");
        }
        else {
            resp.setMensaje(String.format("El carrito con el id %d no se encuentra", id));
        }
        resp.setCarrito(carritoDto);
        return resp;
    }
}
