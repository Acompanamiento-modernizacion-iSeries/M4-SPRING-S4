package com.bancolombia.sistemabancario.sistemabancario.controllers;


import com.bancolombia.sistemabancario.sistemabancario.models.Cuenta;
import com.bancolombia.sistemabancario.sistemabancario.models.DTO.TransaccionDTO;
import com.bancolombia.sistemabancario.sistemabancario.services.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    private TransaccionService transaccioService;

    public TransaccionController(TransaccionService transaccioService) {
        this.transaccioService = transaccioService;
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccion) {
        Cuenta datosCuenta = transaccioService.deposito(transaccion);
        return "Repósito realizado con exito\n" + datosCuenta.toString();
    }

    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccion) {
        Cuenta datosCuenta = transaccioService.retiro(transaccion);
        return "Retiro realizado con exito\n" + datosCuenta.toString();
    }



}
