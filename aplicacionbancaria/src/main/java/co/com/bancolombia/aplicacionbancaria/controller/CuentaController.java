package co.com.bancolombia.aplicacionbancaria.controller;

import co.com.bancolombia.aplicacionbancaria.dto.CuentaDTO;
import co.com.bancolombia.aplicacionbancaria.dto.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.service.CuentaService;
import co.com.bancolombia.aplicacionbancaria.service.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService CUENTA_SERVICE;
    private final TransaccionService TRANSACCION_SERVICE;

    public CuentaController(CuentaService cuentaService, TransaccionService transaccion_service) {
        this.CUENTA_SERVICE = cuentaService;
        this.TRANSACCION_SERVICE = transaccion_service;
    }

    @GetMapping("/saldo")
    public String saldo(@Valid @RequestBody CuentaDTO cuenta) {
        return "Su saldo actual es $"
                + CUENTA_SERVICE.consultarSaldo(cuenta);
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccion) {
        BigDecimal nuevoSaldo = CUENTA_SERVICE.deposito(transaccion);

        TRANSACCION_SERVICE.agregarTransaccion(
                transaccion,
                "deposito",
                CUENTA_SERVICE.buscarCuenta(transaccion.idCuenta())
        );

        return "Deposito realizado con éxito! "
                + "- Nuevo saldo: $" + nuevoSaldo;
    }

    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccion) {
        BigDecimal nuevoSaldo = CUENTA_SERVICE.retiro(transaccion);

        TRANSACCION_SERVICE.agregarTransaccion(
                transaccion,
                "retiro",
                CUENTA_SERVICE.buscarCuenta(transaccion.idCuenta())
        );

        return "Retiro realizado con éxito! "
                + "- Nuevo saldo: $" + nuevoSaldo;
    }
}
