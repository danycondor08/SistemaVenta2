package com.tuempresa.sistemaventas.repository;

import com.tuempresa.sistemaventas.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}
