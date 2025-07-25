package com.tuempresa.sistemaventas.service;

import com.tuempresa.sistemaventas.model.Equipo;
import java.util.List;

public interface EquipoService {
    Equipo guardar(Equipo equipo);
    Equipo obtenerPorId(Long id);
    Equipo actualizar(Long id, Equipo equipo);
    void eliminar(Long id);
    List<Equipo> listar();

    // NUEVO MÉTODO para consultar stock
    int obtenerStockPorId(Long id);
}
