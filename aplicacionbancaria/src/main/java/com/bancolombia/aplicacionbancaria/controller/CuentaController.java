package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.model.DTO.ConsultaDTO;
import com.bancolombia.aplicacionbancaria.model.DTO.TransaccionDTO;
import com.bancolombia.aplicacionbancaria.model.Transaccion;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

   private final CuentaService cuentaService;
    private Transaccion nuevoSaldo;
    private BigDecimal saldo;


    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public String obtenerSaldo(@Valid @RequestBody ConsultaDTO consulta){
        return "EL saldo es de: " + cuentaService.obtenerSaldo(consulta);
    }

    //recibir un body desde el create esto es tipo JSON
    @PostMapping("/ejecutatransaccion")
    public String ejecutarTransaccion(@Valid @RequestBody TransaccionDTO transaccion){
        nuevoSaldo = cuentaService.ejecutaTransaccion(transaccion);
        saldo = cuentaService.obtenerSaldo1(transaccion);
        return nuevoSaldo.getTipoTransaccion() + " realizado con exitoso, el nuevo saldo es de: " + saldo ;
    }
}
