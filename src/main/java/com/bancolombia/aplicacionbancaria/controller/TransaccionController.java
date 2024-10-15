package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.transaccion.Transaccion;
import com.bancolombia.aplicacionbancaria.transaccion.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    private final TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionController(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    @GetMapping
    public List<Transaccion> getTransacciones() {
        return transaccionRepository.findAll();
    }
}
