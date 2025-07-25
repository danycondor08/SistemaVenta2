package com.tuempresa.sistemaventas.service.impl;

import com.tuempresa.sistemaventas.model.Alquiler;
import com.tuempresa.sistemaventas.repository.AlquilerRepository;
import com.tuempresa.sistemaventas.service.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerServiceImpl implements AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Override
    public List<Alquiler> findAll() {
        return alquilerRepository.findAll();
    }

    @Override
    public Alquiler findById(Long id) {
        return alquilerRepository.findById(id).orElse(null);
    }

    @Override
    public Alquiler save(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    @Override
    public Alquiler update(Long id, Alquiler alquiler) {
        alquiler.setId(id);  // Asegúrate que tenga setId
        return alquilerRepository.save(alquiler);
    }

    @Override
    public void delete(Long id) {
        alquilerRepository.deleteById(id);
    }
}
