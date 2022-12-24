package com.example.carrito.controladores;

import com.example.carrito.dto.ClienteDto;
import com.example.carrito.servicios.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteControlador {
    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public ResponseEntity<?> obtenerClientes() {
        return new ResponseEntity<>(clienteServicio.listar(), HttpStatus.OK);
    }

    @PostMapping("/clientes/nuevo")
    public ResponseEntity<?> guardarCliente(@RequestBody ClienteDto cliente){
        return new ResponseEntity<>(clienteServicio.agregar(cliente),HttpStatus.OK);
    }

    @DeleteMapping("/clientes/eliminar/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id){
        return new ResponseEntity<>(clienteServicio.eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/clientes/obtener/{id}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable Long id){
        return new ResponseEntity<>(clienteServicio.obtener(id),HttpStatus.OK);
    }
}
