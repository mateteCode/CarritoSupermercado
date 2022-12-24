package com.example.carrito.servicios;

import com.example.carrito.dto.MarcaDto;
import com.example.carrito.dto.RespMarcaDto;
import com.example.carrito.entidades.Marca;
import com.example.carrito.repositorios.IMarcaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaServicio implements IMarcaServicio{

    @Autowired
    private IMarcaRepositorio marcaRepositorio;

    @Override
    public RespMarcaDto agregar(MarcaDto marcaDto) {
        ModelMapper modelMapper = new ModelMapper();
        Marca marca = modelMapper.map(marcaDto, Marca.class);
        Marca marcaPersistido = marcaRepositorio.save(marca);
        RespMarcaDto resp = new RespMarcaDto();
        resp.setMarca(modelMapper.map(marcaPersistido, MarcaDto.class));
        resp.setMensaje("Se guardó con éxito...");
        return resp;
    }

    @Override
    public RespMarcaDto eliminar(Long id) {
        RespMarcaDto resp = new RespMarcaDto();
        MarcaDto marcaDto = new MarcaDto();
        Optional<Marca> marcaOptional = marcaRepositorio.findById(id);
        if(marcaOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            marcaDto = mapper.map(marcaOptional.get(), MarcaDto.class);
            marcaRepositorio.deleteById(id);
            resp.setMensaje("La marca ha sido borrada");
        }
        else {
            resp.setMensaje("No existe esa marca");
            marcaDto.setId(id);
        }
        resp.setMarca(marcaDto);
        return resp;
    }

    @Override
    public List<MarcaDto> listar() {
        ModelMapper mapper = new ModelMapper();
        List<Marca> marcas = marcaRepositorio.findAll();
        List<MarcaDto> marcasDto = new ArrayList<>();
        marcas.stream().forEach(c-> marcasDto.add(mapper.map(c, MarcaDto.class)));
        return marcasDto;
    }

    @Override
    public RespMarcaDto obtener(Long id) {
        RespMarcaDto resp = new RespMarcaDto();
        MarcaDto marcaDto = new MarcaDto();
        Optional<Marca> marcaOptional = marcaRepositorio.findById(id);
        if(marcaOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            marcaDto = mapper.map(marcaOptional.get(), MarcaDto.class);
            resp.setMensaje("La marca ha sido obtenida");
        }
        else {
            resp.setMensaje("La marca con ese id no se encuentra");
            marcaDto.setId(id);
        }
        resp.setMarca(marcaDto);
        return resp;

    }
}
