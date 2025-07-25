package com.tuempresa.sistemaventas.model;

import jakarta.persistence.*;

@Entity
public class DetalleAlquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alquiler alquiler;

    @ManyToOne
    private Equipo equipo;

    private int cantidad;
    private double precio;

    public DetalleAlquiler() {}

    public DetalleAlquiler(Long id, Alquiler alquiler, Equipo equipo, int cantidad, double precio) {
        this.id = id;
        this.alquiler = alquiler;
        this.equipo = equipo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Alquiler getAlquiler() { return alquiler; }
    public void setAlquiler(Alquiler alquiler) { this.alquiler = alquiler; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
