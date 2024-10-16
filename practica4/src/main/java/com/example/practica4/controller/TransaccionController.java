package com.example.practica4.controller;

import com.example.practica4.model.DTO.TransaccionDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.practica4.service.CuentasService;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    private final CuentasService cuentaService;

    public TransaccionController(CuentasService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("/deposito/{numeroCuenta}")
    public ResponseEntity<String> realizarDeposito(@PathVariable String numeroCuenta, @Valid @RequestBody TransaccionDTO transaccionDTO) {
        cuentaService.depositar(numeroCuenta, transaccionDTO.getMonto());
        return ResponseEntity.ok("Depósito exitoso");
    }

    @PostMapping("/retiro/{numeroCuenta}")
    public ResponseEntity<String> realizarRetiro(@PathVariable String numeroCuenta, @Valid @RequestBody TransaccionDTO transaccionDTO) {
        cuentaService.retirar(numeroCuenta, transaccionDTO.getMonto());
        return ResponseEntity.ok("Retiro exitoso");
    }
}