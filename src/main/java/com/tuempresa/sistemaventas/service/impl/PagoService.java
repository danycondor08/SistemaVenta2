package com.tuempresa.sistemaventas.service;

import com.tuempresa.sistemaventas.model.Pago;
import java.util.List;

public interface PagoService {
    List<Pago> listar();
    Pago obtenerPorId(Long id);
    Pago guardar(Pago pago);
    void eliminar(Long id);
}
