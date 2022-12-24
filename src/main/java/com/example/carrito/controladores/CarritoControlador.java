package com.example.carrito.controladores;

import com.example.carrito.dto.CarritoDto;
import com.example.carrito.servicios.ICarritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarritoControlador {
    @Autowired
    private ICarritoServicio carritoServicio;

    @GetMapping("/carritos")
    public ResponseEntity<?> obtenerCarritos() {
        return new ResponseEntity<>(carritoServicio.listar(), HttpStatus.OK);
    }

    @PostMapping("/carritos/nuevo")
    public ResponseEntity<?> guardarCarrito(@RequestBody CarritoDto carrito){
        return new ResponseEntity<>(carritoServicio.agregar(carrito),HttpStatus.OK);
    }

    @DeleteMapping("/carritos/eliminar/{id}")
    public ResponseEntity<?> eliminarCarrito(@PathVariable Long id){
        return new ResponseEntity<>(carritoServicio.eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/carritos/obtener/{id}")
    public ResponseEntity<?> obtenerCarritoPorId(@PathVariable Long id){
        return new ResponseEntity<>(carritoServicio.obtener(id),HttpStatus.OK);
    }
}
