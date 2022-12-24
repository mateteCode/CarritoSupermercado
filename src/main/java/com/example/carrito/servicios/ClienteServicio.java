package com.example.carrito.servicios;

import com.example.carrito.dto.ClienteDto;
import com.example.carrito.dto.RespClienteDto;
import com.example.carrito.entidades.Cliente;
import com.example.carrito.repositorios.IClienteRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio implements IClienteServicio{
    @Autowired
    private IClienteRepositorio clienteRepositorio;

    @Override
    public RespClienteDto agregar(ClienteDto clienteDto) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        Cliente clientePersistido = clienteRepositorio.save(cliente);
        RespClienteDto resp = new RespClienteDto();
        resp.setCliente(modelMapper.map(clientePersistido, ClienteDto.class));
        resp.setMensaje("Se guardó con éxito...");
        return resp;
    }

    @Override
    public RespClienteDto eliminar(Long id) {
        RespClienteDto resp = new RespClienteDto();
        ClienteDto clienteDto = new ClienteDto();
        Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
        if(clienteOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            clienteDto = mapper.map(clienteOptional.get(), ClienteDto.class);
            clienteRepositorio.deleteById(id);
            resp.setMensaje("El cliente ha sido borrado");
        }
        else {
            resp.setMensaje("No existe ese cliente");
            clienteDto.setId(id);
        }
        resp.setCliente(clienteDto);
        return resp;
    }

    @Override
    public List<ClienteDto> listar() {
        ModelMapper mapper = new ModelMapper();
        List<Cliente> clientes = clienteRepositorio.findAll();
        List<ClienteDto> clientesDto = new ArrayList<>();
        clientes.stream().forEach(c-> clientesDto.add(mapper.map(c, ClienteDto.class)));
        return clientesDto;
    }

    @Override
    public RespClienteDto obtener(Long id) {
        RespClienteDto resp = new RespClienteDto();
        ClienteDto clienteDto = null;
        Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
        if(clienteOptional.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            clienteDto = mapper.map(clienteOptional.get(), ClienteDto.class);
            resp.setMensaje("El cliente ha sido obtenido");
        }
        else {
            resp.setMensaje(String.format("El cliente con el id %d no se encuentra", id));
        }
        resp.setCliente(clienteDto);
        return resp;
    }
}
