package com.tuempresa.sistemaventas.controller;

import com.tuempresa.sistemaventas.model.CategoriaEquipo;
import com.tuempresa.sistemaventas.service.CategoriaEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaEquipoController {

    @Autowired
    private CategoriaEquipoService categoriaEquipoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
    public List<CategoriaEquipo> listar() {
        return categoriaEquipoService.listar();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoriaEquipo> guardar(@RequestBody CategoriaEquipo categoria) {
        return ResponseEntity.ok(categoriaEquipoService.guardar(categoria));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'VENDEDOR')")
    public ResponseEntity<CategoriaEquipo> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaEquipoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoriaEquipo> actualizar(@PathVariable Long id, @RequestBody CategoriaEquipo categoria) {
        return ResponseEntity.ok(categoriaEquipoService.actualizar(id, categoria));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaEquipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
