package com.bancolombia.aplicacionbancaria.controller;

import com.bancolombia.aplicacionbancaria.model.CuentaDTO;
import com.bancolombia.aplicacionbancaria.model.DepositoDTO;
import com.bancolombia.aplicacionbancaria.model.RetiroDTO;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(@Valid @RequestBody CuentaDTO cuentaDTO) {
        return cuentaService.obtenerSaldo(cuentaDTO);
    }

    @PostMapping("/depositobody")
    public String despositarbody(@Valid @RequestBody DepositoDTO transactionDTO) {
        return cuentaService.depositar(transactionDTO).toString();
    }

    @PostMapping("/retirarbody")
    public String retirarbody(@Valid @RequestBody RetiroDTO retiroDTO) {
        return cuentaService.retirar(retiroDTO).toString();
    }

}
