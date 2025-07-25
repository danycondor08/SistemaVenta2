package com.tuempresa.sistemaventas.service.impl;

import com.tuempresa.sistemaventas.model.CategoriaEquipo;
import com.tuempresa.sistemaventas.repository.CategoriaEquipoRepository;
import com.tuempresa.sistemaventas.service.CategoriaEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaEquipoServiceImpl implements CategoriaEquipoService {

    @Autowired
    private CategoriaEquipoRepository repository;

    @Override
    public List<CategoriaEquipo> listar() {
        return repository.findAll();
    }

    @Override
    public CategoriaEquipo guardar(CategoriaEquipo categoria) {
        return repository.save(categoria);
    }

    @Override
    public CategoriaEquipo obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CategoriaEquipo actualizar(Long id, CategoriaEquipo categoria) {
        categoria.setId(id);
        return repository.save(categoria);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
