package com.example.carrito.servicios;

import com.example.carrito.dto.CategoriaDto;
import com.example.carrito.dto.MarcaDto;
import com.example.carrito.dto.RespCategoriaDto;
import com.example.carrito.dto.RespMarcaDto;
import com.example.carrito.entidades.Categoria;
import com.example.carrito.entidades.Marca;
import com.example.carrito.repositorios.ICategoriaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio implements ICategoriaServicio{
    @Autowired
    private ICategoriaRepositorio categoriaRepositorio;

    @Override
    public RespCategoriaDto agregar(CategoriaDto categoriaDto) {
        ModelMapper modelMapper = new ModelMapper();
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria categoriaPersistido = categoriaRepositorio.save(categoria);
        RespCategoriaDto resp = new RespCategoriaDto();
        resp.setCategoria(modelMapper.map(categoriaPersistido, CategoriaDto.class));
        resp.setMensaje("Se guardó con éxito...");
        return resp;
    }

    @Override
    public RespCategoriaDto eliminar(Long id) {
        RespCategoriaDto resp = new RespCategoriaDto();
        CategoriaDto categoriaDto = new CategoriaDto();
        Optional<Categoria> categoriaOptional = categoriaRepositorio.findById(id);
        if(categoriaOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            categoriaDto = mapper.map(categoriaOptional.get(), CategoriaDto.class);
            categoriaRepositorio.deleteById(id);
            resp.setMensaje("La categoria ha sido borrada");
        }
        else {
            resp.setMensaje("No existe esa categoria");
            categoriaDto.setId(id);
        }
        resp.setCategoria(categoriaDto);
        return resp;
    }

    @Override
    public List<CategoriaDto> listar() {
        ModelMapper mapper = new ModelMapper();
        List<Categoria> categorias = categoriaRepositorio.findAll();
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        categorias.stream().forEach(c-> categoriasDto.add(mapper.map(c, CategoriaDto.class)));
        return categoriasDto;
    }

    @Override
    public RespCategoriaDto obtener(Long id) {
        RespCategoriaDto resp = new RespCategoriaDto();
        CategoriaDto categoriaDto = new CategoriaDto();
        Optional<Categoria> categoriaOptional = categoriaRepositorio.findById(id);
        if(categoriaOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            categoriaDto = mapper.map(categoriaOptional.get(), CategoriaDto.class);
            resp.setMensaje("La categoria ha sido obtenida");
        }
        else {
            resp.setMensaje("La categoria con ese id no se encuentra");
            categoriaDto.setId(id);
        }
        resp.setCategoria(categoriaDto);
        return resp;
    }
}
