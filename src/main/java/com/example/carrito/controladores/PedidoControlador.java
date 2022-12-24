package com.example.carrito.controladores;

import com.example.carrito.dto.PedidoDto;
import com.example.carrito.dto.ProductoDto;
import com.example.carrito.servicios.IPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoControlador {
    @Autowired
    private IPedidoServicio pedidoServicio;

    @GetMapping("/pedidos")
    public ResponseEntity<?> obtenerPedidos() {
        return new ResponseEntity<>(pedidoServicio.listar(), HttpStatus.OK);
    }

    @PostMapping("/pedidos/nuevo")
    public ResponseEntity<?> guardarPedidos(@RequestBody PedidoDto pedido){
        return new ResponseEntity<>(pedidoServicio.agregar(pedido),HttpStatus.OK);
    }

    @DeleteMapping("/pedidos/eliminar/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Long id){
        return new ResponseEntity<>(pedidoServicio.eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/pedidos/obtener/{id}")
    public ResponseEntity<?> obtenerPedidoPorId(@PathVariable Long id){
        return new ResponseEntity<>(pedidoServicio.obtener(id),HttpStatus.OK);
    }
}
