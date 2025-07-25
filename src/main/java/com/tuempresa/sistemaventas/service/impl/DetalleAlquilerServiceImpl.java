package com.tuempresa.sistemaventas.service.impl;

import com.tuempresa.sistemaventas.model.DetalleAlquiler;
import com.tuempresa.sistemaventas.repository.DetalleAlquilerRepository;
import com.tuempresa.sistemaventas.service.DetalleAlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleAlquilerServiceImpl implements DetalleAlquilerService {

    @Autowired
    private DetalleAlquilerRepository detalleAlquilerRepository;

    @Override
    public DetalleAlquiler guardar(DetalleAlquiler detalle) {
        return detalleAlquilerRepository.save(detalle);
    }

    @Override
    public DetalleAlquiler obtenerPorId(Long id) {
        return detalleAlquilerRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleAlquiler actualizar(Long id, DetalleAlquiler detalle) {
        DetalleAlquiler existente = detalleAlquilerRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setCantidad(detalle.getCantidad());
            existente.setPrecio(detalle.getPrecio());
            // Puedes agregar más campos aquí si es necesario
            return detalleAlquilerRepository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        detalleAlquilerRepository.deleteById(id);
    }

    @Override
    public List<DetalleAlquiler> listar() {
        return detalleAlquilerRepository.findAll();
    }
}
