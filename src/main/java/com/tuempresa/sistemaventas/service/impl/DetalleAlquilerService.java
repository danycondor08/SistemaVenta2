package com.tuempresa.sistemaventas.service;

import com.tuempresa.sistemaventas.model.DetalleAlquiler;

import java.util.List;

public interface DetalleAlquilerService {
    DetalleAlquiler guardar(DetalleAlquiler detalle);
    DetalleAlquiler obtenerPorId(Long id);
    DetalleAlquiler actualizar(Long id, DetalleAlquiler detalle);
    void eliminar(Long id);
    List<DetalleAlquiler> listar();
}
