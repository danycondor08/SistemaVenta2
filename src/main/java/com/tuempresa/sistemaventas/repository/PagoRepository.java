package com.tuempresa.sistemaventas.repository;

import com.tuempresa.sistemaventas.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}
