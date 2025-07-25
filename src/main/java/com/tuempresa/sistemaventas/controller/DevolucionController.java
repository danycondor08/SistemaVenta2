package com.tuempresa.sistemaventas.controller;

import com.tuempresa.sistemaventas.model.Devolucion;
import com.tuempresa.sistemaventas.service.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @GetMapping
    public List<Devolucion> listar() {
        return devolucionService.findAll();
    }

    @GetMapping("/{id}")
    public Devolucion obtenerPorId(@PathVariable Long id) {
        return devolucionService.findById(id);
    }

    @PostMapping
    public Devolucion crear(@RequestBody Devolucion devolucion) {
        return devolucionService.save(devolucion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        devolucionService.deleteById(id);
    }
}
