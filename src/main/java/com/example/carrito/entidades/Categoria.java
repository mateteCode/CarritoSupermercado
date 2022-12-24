package com.example.carrito.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NOMBRE", nullable = false, length = 30, unique = true)
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
