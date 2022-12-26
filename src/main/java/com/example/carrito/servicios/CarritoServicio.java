package com.example.carrito.servicios;

import com.example.carrito.dto.CarritoDto;
import com.example.carrito.dto.PedidoDtoCarrito;
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

    @Autowired
    private IPedidoServicio pedidoServicio;

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
        carritos.stream().forEach(carrito-> {
            CarritoDto carritoDto = mapper.map(carrito, CarritoDto.class);
            List<PedidoDtoCarrito> pedidos = pedidoServicio.listarPorCarrito(carrito);
            carritoDto.setPedidos(pedidos);
            Double total  = 0d;
            for (PedidoDtoCarrito p: pedidos)
                total += p.subTotal();
            carritoDto.setPrecioTotal(total);
            carritosDto.add(carritoDto);
        });
        return carritosDto;
    }

    @Override
    public RespCarritoDto obtener(Long id) {
        RespCarritoDto resp = new RespCarritoDto();
        CarritoDto carritoDto = null;
        Optional<Carrito> carritoOptional = carritoRepositorio.findById(id);
        if(carritoOptional.isPresent()) {
            Carrito carrito = carritoOptional.get();
            ModelMapper mapper = new ModelMapper();
            List<PedidoDtoCarrito> pedidos = pedidoServicio.listarPorCarrito(carrito);
            Double total  = 0d;
            carritoDto = mapper.map(carrito, CarritoDto.class);
            resp.setMensaje("El carrito ha sido obtenido");
            carritoDto.setPedidos(pedidos);
            for (PedidoDtoCarrito p: pedidos)
                total += p.subTotal();
            carritoDto.setPrecioTotal(total);
        }
        else {
            resp.setMensaje(String.format("El carrito con el id %d no se encuentra", id));
        }
        resp.setCarrito(carritoDto);
        return resp;
    }
}
