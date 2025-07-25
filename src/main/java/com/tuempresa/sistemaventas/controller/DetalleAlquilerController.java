package com.tuempresa.sistemaventas.controller;

import com.tuempresa.sistemaventas.model.DetalleAlquiler;
import com.tuempresa.sistemaventas.service.DetalleAlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
@CrossOrigin(origins = "*")
public class DetalleAlquilerController {

    @Autowired
    private DetalleAlquilerService detalleAlquilerService;

    @GetMapping
    public List<DetalleAlquiler> listar() {
        return detalleAlquilerService.listar();
    }

    @PostMapping
    public ResponseEntity<DetalleAlquiler> guardar(@RequestBody DetalleAlquiler detalle) {
        return ResponseEntity.ok(detalleAlquilerService.guardar(detalle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleAlquiler> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detalleAlquilerService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleAlquiler> actualizar(@PathVariable Long id, @RequestBody DetalleAlquiler detalle) {
        return ResponseEntity.ok(detalleAlquilerService.actualizar(id, detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        detalleAlquilerService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
