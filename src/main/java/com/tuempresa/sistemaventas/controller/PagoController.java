package com.tuempresa.sistemaventas.controller;

import com.tuempresa.sistemaventas.model.Pago;
import com.tuempresa.sistemaventas.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    @GetMapping
    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pago getById(@PathVariable Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pago create(@RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable Long id, @RequestBody Pago pago) {
        pago.setId(id);
        return pagoRepository.save(pago);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pagoRepository.deleteById(id);
    }
}
