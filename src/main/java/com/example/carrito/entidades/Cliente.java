package com.example.carrito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CLIENTES")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Column(name="USUARIO", nullable = false, length = 50, unique = true)
    private String usuario;

    @Column(name="PASSWORD", nullable = false, length = 50)
    private String password;

    public Cliente(String nombre, String usuario, String password) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
    }
}
