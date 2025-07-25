package com.tuempresa.sistemaventas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Alquiler alquiler;

    private double monto;
    private LocalDate fechaPago;
    private String metodo;

    public Pago() {}

    public Pago(Long id, Alquiler alquiler, double monto, LocalDate fechaPago, String metodo) {
        this.id = id;
        this.alquiler = alquiler;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodo = metodo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Alquiler getAlquiler() { return alquiler; }
    public void setAlquiler(Alquiler alquiler) { this.alquiler = alquiler; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public LocalDate getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDate fechaPago) { this.fechaPago = fechaPago; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }
}
