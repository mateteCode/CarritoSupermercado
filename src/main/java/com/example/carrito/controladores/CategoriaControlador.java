package com.example.carrito.controladores;

import com.example.carrito.dto.CategoriaDto;
import com.example.carrito.servicios.ICategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaControlador {

    @Autowired
    private ICategoriaServicio categoriaServicio;

    @GetMapping("/categorias")
    public ResponseEntity<?> obtenerCategorias() {
        return new ResponseEntity<>(categoriaServicio.listar(), HttpStatus.OK);
    }

    @PostMapping("/categorias/nuevo")
    public ResponseEntity<?> guardarCategoria(@RequestBody CategoriaDto categoria){
        return new ResponseEntity<>(categoriaServicio.agregar(categoria),HttpStatus.OK);
    }

    @DeleteMapping("/categorias/eliminar/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id){
        return new ResponseEntity<>(categoriaServicio.eliminar(id),HttpStatus.OK);
    }

    @GetMapping("/categorias/obtener/{id}")
    public ResponseEntity<?> obtenerCategoriaPorId(@PathVariable Long id){
        return new ResponseEntity<>(categoriaServicio.obtener(id),HttpStatus.OK);
    }
}
