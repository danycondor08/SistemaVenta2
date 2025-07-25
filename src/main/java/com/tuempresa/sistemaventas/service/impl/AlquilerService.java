package com.tuempresa.sistemaventas.service;

import com.tuempresa.sistemaventas.model.Alquiler;

import java.util.List;

public interface AlquilerService {
    List<Alquiler> findAll();
    Alquiler findById(Long id);
    Alquiler save(Alquiler alquiler);
    Alquiler update(Long id, Alquiler alquiler);
    void delete(Long id);
}
