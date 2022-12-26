package com.example.carrito.servicios;

import com.example.carrito.dto.PedidoDto;
import com.example.carrito.dto.PedidoDtoCarrito;
import com.example.carrito.dto.RespPedidoDto;
import com.example.carrito.entidades.Carrito;
import com.example.carrito.entidades.Pedido;
import com.example.carrito.repositorios.IPedidoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio implements IPedidoServicio{
    @Autowired
    private IPedidoRepositorio pedidoRepositorio;

    @Override
    public RespPedidoDto agregar(PedidoDto pedidoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Pedido pedido = modelMapper.map(pedidoDto, Pedido.class);
        Pedido pedidoPersistido = pedidoRepositorio.save(pedido);
        RespPedidoDto resp = new RespPedidoDto();
        resp.setPedido(modelMapper.map(pedidoPersistido, PedidoDto.class));
        resp.setMensaje("Se guardó con éxito...");
        return resp;
    }

    @Override
    public RespPedidoDto eliminar(Long id) {
        RespPedidoDto resp = new RespPedidoDto();
        PedidoDto pedidoDto = new PedidoDto();
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);
        if(pedidoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            pedidoDto = mapper.map(pedidoOptional.get(), PedidoDto.class);
            pedidoRepositorio.deleteById(id);
            resp.setMensaje("El pedido ha sido borrado");
        }
        else {
            resp.setMensaje("No existe ese pedido");
            pedidoDto.setId(id);
        }
        resp.setPedido(pedidoDto);
        return resp;
    }

    @Override
    public List<PedidoDto> listar() {
        ModelMapper mapper = new ModelMapper();
        List<Pedido> pedidos = pedidoRepositorio.findAll();
        List<PedidoDto> pedidosDto = new ArrayList<>();
        pedidos.stream().forEach(c-> pedidosDto.add(mapper.map(c, PedidoDto.class)));
        return pedidosDto;
    }

    @Override
    public RespPedidoDto obtener(Long id) {
        RespPedidoDto resp = new RespPedidoDto();
        PedidoDto pedidoDto = null;
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(id);
        if(pedidoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            pedidoDto = mapper.map(pedidoOptional.get(), PedidoDto.class);
            resp.setMensaje("El pedido ha sido obtenido");
        }
        else {
            resp.setMensaje(String.format("El pedido con el id %d no se encuentra", id));
        }
        resp.setPedido(pedidoDto);
        return resp;
    }

    @Override
    public List<PedidoDtoCarrito> listarPorCarrito(Carrito carrito) {
        ModelMapper mapper = new ModelMapper();
        List<Pedido> pedidos = pedidoRepositorio.findAllByCarrito(carrito);
        List<PedidoDtoCarrito> pedidosDtoCarrito = new ArrayList<>();
        pedidos.stream().forEach(c-> pedidosDtoCarrito.add(mapper.map(c, PedidoDtoCarrito.class)));
        return pedidosDtoCarrito;
    }
}
