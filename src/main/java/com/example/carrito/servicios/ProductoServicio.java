package com.example.carrito.servicios;

import com.example.carrito.dto.*;
import com.example.carrito.entidades.Marca;
import com.example.carrito.entidades.Producto;
import com.example.carrito.entidades.Tipo;
import com.example.carrito.repositorios.IMarcaRepositorio;
import com.example.carrito.repositorios.IProductoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private IProductoRepositorio productoRepositorio;

    @Override
    public RespProductoDto agregar(ProductoDto productoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Producto producto = modelMapper.map(productoDto, Producto.class);
        System.out.println(producto);
        Producto productoPersistido = productoRepositorio.save(producto);
        System.out.println(productoPersistido);
        RespProductoDto resp = new RespProductoDto();
        //resp.setProducto(modelMapper.map(producto, ProductoDto.class));
        resp.setProducto(modelMapper.map(productoPersistido, ProductoDto.class));
        resp.setMensaje("Se guardó con éxito...");
        return resp;
    }

    @Override
    public RespProductoDto eliminar(Long id) {
        RespProductoDto resp = new RespProductoDto();
        ProductoDto productoDto = new ProductoDto();
        Optional<Producto> productoOptional = productoRepositorio.findById(id);
        if(productoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            productoDto = mapper.map(productoOptional.get(), ProductoDto.class);
            productoRepositorio.deleteById(id);
            resp.setMensaje("El producto ha sido borrado");
        }
        else {
            resp.setMensaje("No existe ese producto");
            productoDto.setId(id);
        }
        resp.setProducto(productoDto);
        return resp;
    }

    @Override
    public List<ProductoDto> listar() {
        ModelMapper mapper = new ModelMapper();
        List<Producto> productos = productoRepositorio.findAll();
        List<ProductoDto> productosDto = new ArrayList<>();
        productos.stream().forEach(c-> productosDto.add(mapper.map(c, ProductoDto.class)));
        return productosDto;
    }

    @Override
    public RespProductoDto obtener(Long id) {
        RespProductoDto resp = new RespProductoDto();
        ProductoDto productoDto = null;
        Optional<Producto> productoOptional = productoRepositorio.findById(id);
        if(productoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            productoDto = mapper.map(productoOptional.get(), ProductoDto.class);
            resp.setMensaje("El producto ha sido obtenido");
        }
        else {
            resp.setMensaje(String.format("El producto con el id %d no se encuentra", id));
        }
        resp.setProducto(productoDto);
        return resp;
    }
}
