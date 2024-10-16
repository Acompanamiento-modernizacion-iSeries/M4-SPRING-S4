package com.bancolombia.aplicacionbanco.controller;

import com.bancolombia.aplicacionbanco.DTO.CuentaDTO;
import com.bancolombia.aplicacionbanco.DTO.TransaccionDTO;
import com.bancolombia.aplicacionbanco.service.CuentaService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(@Valid @RequestBody CuentaDTO cuentaDTO){
        System.out.println(cuentaDTO.toString());
        return cuentaService.obtenerSaldo(cuentaDTO);
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccionDto){
        System.out.println(transaccionDto.toString());
        return "Deposito: "+cuentaService.depositar(transaccionDto);
    }

    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccionDto) {
        System.out.println(transaccionDto.toString());
        return "Retiro: "+cuentaService.retirar(transaccionDto);
    }
}
