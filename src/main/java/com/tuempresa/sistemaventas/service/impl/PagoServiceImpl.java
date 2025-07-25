package com.tuempresa.sistemaventas.service.impl;

import com.tuempresa.sistemaventas.model.Pago;
import com.tuempresa.sistemaventas.repository.PagoRepository;
import com.tuempresa.sistemaventas.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago obtenerPorId(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public void eliminar(Long id) {
        pagoRepository.deleteById(id);
    }
}

