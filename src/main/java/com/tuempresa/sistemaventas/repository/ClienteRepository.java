package com.tuempresa.sistemaventas.repository;

import com.tuempresa.sistemaventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
