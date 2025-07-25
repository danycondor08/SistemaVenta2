package com.tuempresa.sistemaventas.service;

import com.tuempresa.sistemaventas.model.CategoriaEquipo;

import java.util.List;

public interface CategoriaEquipoService {
    List<CategoriaEquipo> listar();
    CategoriaEquipo guardar(CategoriaEquipo categoria);
    CategoriaEquipo obtenerPorId(Long id);
    CategoriaEquipo actualizar(Long id, CategoriaEquipo categoria);
    void eliminar(Long id);
}
