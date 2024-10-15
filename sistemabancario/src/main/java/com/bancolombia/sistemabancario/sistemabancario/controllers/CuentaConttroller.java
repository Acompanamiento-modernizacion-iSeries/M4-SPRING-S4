package com.bancolombia.sistemabancario.sistemabancario.controllers;

import java.util.List;


import com.bancolombia.sistemabancario.sistemabancario.models.DTO.ConsultaPorCuentaDTO;
import com.bancolombia.sistemabancario.sistemabancario.models.DTO.RegistrarCuentaDTO;
import com.bancolombia.sistemabancario.sistemabancario.services.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.bancolombia.sistemabancario.sistemabancario.models.Cuenta;


@RestController
@RequestMapping("/cuenta")
public class CuentaConttroller {

    private CuentaService cuentaService;
    public CuentaConttroller(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }


    @GetMapping("/saldo")
    public String  saldo(@Valid @RequestBody ConsultaPorCuentaDTO consultaCuenta) {
        Cuenta datosCuenta = cuentaService.obtenerDatosCuenta(consultaCuenta);
        return  datosCuenta.toString();
    }

    @PostMapping("registrocuenta")
    public String registrarCuenta(@Valid @RequestBody RegistrarCuentaDTO registroCuenta){
        Cuenta datosCuenta = cuentaService.registroCuenta(registroCuenta);
        return "Cuenta registrada con exito\n" + datosCuenta.toString();
    }
    
}
