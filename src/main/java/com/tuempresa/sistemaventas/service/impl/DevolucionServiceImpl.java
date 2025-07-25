package com.tuempresa.sistemaventas.service.impl;

import com.tuempresa.sistemaventas.model.Alquiler;
import com.tuempresa.sistemaventas.model.Devolucion;
import com.tuempresa.sistemaventas.model.DetalleAlquiler;
import com.tuempresa.sistemaventas.repository.AlquilerRepository;
import com.tuempresa.sistemaventas.repository.DevolucionRepository;
import com.tuempresa.sistemaventas.repository.EquipoRepository;
import com.tuempresa.sistemaventas.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class DevolucionServiceImpl implements DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public Devolucion registrarDevolucion(Devolucion devolucion) {
        Alquiler alquiler = devolucion.getAlquiler();

        if (alquiler == null || alquiler.getId() == null) {
            throw new RuntimeException("Debe asociar un alquiler válido a la devolución.");
        }

        alquiler = alquilerRepository.findById(alquiler.getId())
                .orElseThrow(() -> new RuntimeException("Alquiler no encontrado"));

        alquiler.setFechaDevolucionReal(devolucion.getFechaDevolucion());

        LocalDate fechaEsperada = alquiler.getFechaDevolucionEsperada();
        LocalDate fechaDev = devolucion.getFechaDevolucion();

        long diasRetraso = ChronoUnit.DAYS.between(fechaEsperada, fechaDev);
        double penalidad = diasRetraso > 0 ? diasRetraso * 10.0 : 0.0;
        devolucion.setPenalidad(penalidad);

        for (DetalleAlquiler detalle : alquiler.getDetalles()) {
            var equipo = detalle.getEquipo();
            equipo.setStock(equipo.getStock() + detalle.getCantidad());
            equipoRepository.save(equipo);
        }

        alquilerRepository.save(alquiler);
        return devolucionRepository.save(devolucion);
    }

    @Override
    public List<Devolucion> findAll() {
        return devolucionRepository.findAll();
    }

    @Override
    public Devolucion findById(Long id) {
        return devolucionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Devolución no encontrada con ID: " + id));
    }

    @Override
    public Devolucion save(Devolucion devolucion) {
        return devolucionRepository.save(devolucion);
    }

    @Override
    public void deleteById(Long id) {
        devolucionRepository.deleteById(id);
    }
}
