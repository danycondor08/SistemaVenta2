package com.tuempresa.sistemaventas.model;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaDevolucion;

    private Double penalidad;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "alquiler_id")
    private Alquiler alquiler;

    // --- Getters y Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Double getPenalidad() {
        return penalidad;
    }

    public void setPenalidad(Double penalidad) {
        this.penalidad = penalidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
}
