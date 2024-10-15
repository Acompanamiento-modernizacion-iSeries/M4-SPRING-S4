package com.bancolombia.aplicacionbancaria.controller;
import com.bancolombia.aplicacionbancaria.service.CuentaService;
import com.bancolombia.aplicacionbancaria.transaccion.TransaccionDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    @Autowired
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public ResponseEntity<String> getSaldo(@RequestParam @NotNull String numeroCuenta) {
        double saldo = cuentaService.consultarSaldo(numeroCuenta);
        return new ResponseEntity<>("El saldo de la cuenta: " + numeroCuenta + " es: " + saldo, HttpStatus.OK);
    }

    @PostMapping("/transaccion/deposito")
    public ResponseEntity<String> realizarDeposito(@RequestBody @Valid TransaccionDTO transaccionDTO) {
        cuentaService.depositar(transaccionDTO.getNumeroCuenta(), transaccionDTO.getMonto());
        return new ResponseEntity<>("Depósito realizado con éxito", HttpStatus.OK);
    }

    @PostMapping("/transaccion/retiro")
    public ResponseEntity<String> realizarRetiro(@RequestBody @Valid TransaccionDTO transaccionDTO) {
        cuentaService.retirar(transaccionDTO.getNumeroCuenta(), transaccionDTO.getMonto());
        return new ResponseEntity<>("Retiro realizado con éxito", HttpStatus.OK);
    }
}


