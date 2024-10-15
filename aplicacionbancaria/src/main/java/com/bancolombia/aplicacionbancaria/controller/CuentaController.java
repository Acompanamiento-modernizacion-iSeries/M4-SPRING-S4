package com.bancolombia.aplicacionbancaria.controller;
import com.bancolombia.aplicacionbancaria.config.MontoInvalidoException;
import com.bancolombia.aplicacionbancaria.config.SaldoInsuficienteException;
import com.bancolombia.aplicacionbancaria.entity.TransaccionDTO;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/saldo")
    public ResponseEntity<String> obtenerSaldo(@RequestParam Long numeroCuenta) {
        BigDecimal saldo = cuentaService.consultarSaldo(numeroCuenta);
        return new ResponseEntity<>("El saldo de la cuenta es: " + saldo, HttpStatus.OK);
    }

    @PostMapping("/deposito")
    public ResponseEntity<String> depositar(@Valid @RequestBody TransaccionDTO transaccion) {
        System.out.println(transaccion.toString());
            cuentaService.depositar(transaccion.getCuenta().getId(), transaccion.getMonto());
            return new ResponseEntity<>("Depósito exitoso", HttpStatus.OK);
    }

    @PostMapping("/retiro")
    public ResponseEntity<String> retirar(@Valid @RequestBody TransaccionDTO transaccion) {
        System.out.println(transaccion.toString());
            cuentaService.retirar(transaccion.getCuenta().getId(), transaccion.getMonto());
            return new ResponseEntity<>("Retiro exitoso", HttpStatus.OK);
    }
}
