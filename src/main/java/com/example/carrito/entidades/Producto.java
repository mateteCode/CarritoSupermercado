package com.example.carrito.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(nullable = false, unique = true)
    //private String codigo;

    @Column(nullable = false, length = 100)
    private String nombre;

    private String descripcion;

    //private Integer stock;

    @Column(nullable = false, scale = 2)
    private Double precio;

    private String foto;

    private Integer peso;

    //@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="ID_CATEGORIA", nullable = false)
    private Categoria categoria;

    //@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="ID_TIPO", nullable = false)
    private Tipo tipo;

    //@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="ID_MARCA", nullable = false)
    private Marca marca;

    public Producto(String nombre, String descripcion, Double precio, String foto, Integer peso, Categoria categoria, Tipo tipo, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.peso = peso;
        this.categoria = categoria;
        this.tipo = tipo;
        this.marca = marca;
    }
}
