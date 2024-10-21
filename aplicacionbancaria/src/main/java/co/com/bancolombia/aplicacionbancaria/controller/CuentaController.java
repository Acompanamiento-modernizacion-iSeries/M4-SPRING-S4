package co.com.bancolombia.aplicacionbancaria.controller;

import co.com.bancolombia.aplicacionbancaria.model.DTO.CuentaDTO;
import co.com.bancolombia.aplicacionbancaria.model.DTO.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(@Valid @RequestBody CuentaDTO cuenta) {
        System.out.println("Información de la cuenta: " + cuenta);
        return cuentaService.obtenerSaldo(cuenta);
    }

    @PostMapping("/deposito")
    public String realizarDeposito(@Valid @RequestBody TransaccionDTO transaccion) {
        System.out.println("Información de la transacción: " + transaccion);
        return "Depósito realizado: " + cuentaService.deposito(transaccion);
    }

    @PostMapping("/retiro")
    public String realizarRetiro(@Valid @RequestBody TransaccionDTO transaccion) {
        System.out.println("Información de la transacción: " + transaccion);
        return "Retiro realizado: " + cuentaService.retiro(transaccion);
    }
}