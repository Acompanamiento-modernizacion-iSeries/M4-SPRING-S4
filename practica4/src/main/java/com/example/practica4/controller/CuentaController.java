package com.example.practica4.controller;

import com.example.practica4.model.DTO.CuentaDTO;
import com.example.practica4.service.CuentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    private CuentasService cuentasService;

    @PostMapping("/deposito")
    public ResponseEntity<String> depositar(@RequestBody CuentaDTO cuentaDTO) {
        cuentasService.depositar(cuentaDTO.getNumeroCuenta(), cuentaDTO.getMonto());
        return ResponseEntity.status(HttpStatus.OK).body("Depósito realizado con éxito");
    }

    @PostMapping("/retiro")
    public ResponseEntity<String> retirar(@RequestBody CuentaDTO cuentaDTO) {
        cuentasService.retirar(cuentaDTO.getNumeroCuenta(), cuentaDTO.getMonto());
        return ResponseEntity.status(HttpStatus.OK).body("Retiro realizado con éxito");
    }

    @GetMapping("/saldo/{numeroCuenta}")
    public ResponseEntity<BigDecimal> consultarSaldo(@PathVariable String numeroCuenta) {
        BigDecimal saldo = cuentasService.consultarSaldo(numeroCuenta);
        return ResponseEntity.ok(saldo);
    }
}
