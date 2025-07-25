package com.tuempresa.sistemaventas.repository;

import com.tuempresa.sistemaventas.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionRepository extends JpaRepository<Devolucion, Long> {
}
