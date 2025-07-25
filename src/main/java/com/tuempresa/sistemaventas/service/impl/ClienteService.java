package com.tuempresa.sistemaventas.service;

import com.tuempresa.sistemaventas.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    Cliente update(Long id, Cliente cliente);
    void delete(Long id);
}