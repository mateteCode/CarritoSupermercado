package com.example.carrito.servicios;

import com.example.carrito.dto.RespTipoDto;
import com.example.carrito.dto.TipoDto;
import com.example.carrito.entidades.Tipo;
import com.example.carrito.repositorios.ITipoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoServicio implements ITipoServicio{
    @Autowired
    private ITipoRepositorio tipoRepositorio;

    @Override
    public RespTipoDto agregar(TipoDto tipoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Tipo tipo = modelMapper.map(tipoDto, Tipo.class);
        Tipo tipoPersistido = tipoRepositorio.save(tipo);
        RespTipoDto resp = new RespTipoDto();
        resp.setTipo(modelMapper.map(tipoPersistido, TipoDto.class));
        resp.setMensaje("Se guardó con éxito...");
        return resp;
    }

    @Override
    public RespTipoDto eliminar(Long id) {
        RespTipoDto resp = new RespTipoDto();
        TipoDto tipoDto = new TipoDto();
        Optional<Tipo> tipoOptional = tipoRepositorio.findById(id);
        if(tipoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            tipoDto = mapper.map(tipoOptional.get(), TipoDto.class);
            tipoRepositorio.deleteById(id);
            resp.setMensaje("El tipo ha sido borrado");
        }
        else {
            resp.setMensaje("No existe ese tipo");
            tipoDto.setId(id);
        }
        resp.setTipo(tipoDto);
        return resp;
    }

    @Override
    public List<TipoDto> listar() {
        ModelMapper mapper = new ModelMapper();
        List<Tipo> tipos = tipoRepositorio.findAll();
        List<TipoDto> tiposDto = new ArrayList<>();
        tipos.stream().forEach(c-> tiposDto.add(mapper.map(c, TipoDto.class)));
        return tiposDto;
    }

    @Override
    public RespTipoDto obtener(Long id) {
        RespTipoDto resp = new RespTipoDto();
        TipoDto tipoDto = new TipoDto();
        Optional<Tipo> tipoOptional = tipoRepositorio.findById(id);
        if(tipoOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            tipoDto = mapper.map(tipoOptional.get(), TipoDto.class);
            resp.setMensaje("El tipo ha sido obtenido");
        }
        else {
            resp.setMensaje("El tipo con ese id no se encuentra");
            tipoDto.setId(id);
        }
        resp.setTipo(tipoDto);
        return resp;
    }
}
