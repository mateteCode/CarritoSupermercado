package com.example.carrito.controladores;

import com.example.carrito.dto.MarcaDto;
import com.example.carrito.dto.TipoDto;
import com.example.carrito.servicios.ITipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TipoControlador {
    @Autowired
    private ITipoServicio tipoServicio;

    @GetMapping("/tipos")
    public ResponseEntity<?> obtenerTipos() {
        return new ResponseEntity<>(tipoServicio.listar(), HttpStatus.OK);
    }

    @PostMapping("/tipos/nuevo")
    public ResponseEntity<?> guardarTipo(@RequestBody TipoDto tipo){
        return new ResponseEntity<>(tipoServicio.agregar(tipo),HttpStatus.OK);
    }

    @DeleteMapping("/tipos/eliminar/{id}")
    public ResponseEntity<?> eliminarTipo(@PathVariable Long id){
        System.out.println(id);
        return new ResponseEntity<>(tipoServicio.eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/tipos/obtener/{id}")
    public ResponseEntity<?> obtenerTipoPorId(@PathVariable Long id){
        return new ResponseEntity<>(tipoServicio.obtener(id),HttpStatus.OK);
    }
}
