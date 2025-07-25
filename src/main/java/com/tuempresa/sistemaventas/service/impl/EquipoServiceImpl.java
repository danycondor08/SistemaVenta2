package com.tuempresa.sistemaventas.service.impl;

import com.tuempresa.sistemaventas.model.Equipo;
import com.tuempresa.sistemaventas.repository.EquipoRepository;
import com.tuempresa.sistemaventas.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo obtenerPorId(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }
    @Override
    public int obtenerStockPorId(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
        return equipo.getStock();
    }

    @Override
    public Equipo actualizar(Long id, Equipo equipo) {
        Equipo existente = equipoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(equipo.getNombre());
            existente.setDescripcion(equipo.getDescripcion());
            existente.setPrecio(equipo.getPrecio());
            // Agrega más campos si es necesario
            return equipoRepository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }
}
