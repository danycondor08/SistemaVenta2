package com.tuempresa.sistemaventas.service;

import com.tuempresa.sistemaventas.model.Devolucion;

import java.util.List;

public interface DevolucionService {
    Devolucion registrarDevolucion(Devolucion devolucion); // lógica especial
    List<Devolucion> findAll();
    Devolucion findById(Long id);

    // Agrega estos métodos para que no marque error en el Controller
    Devolucion save(Devolucion devolucion);
    void deleteById(Long id);
}
