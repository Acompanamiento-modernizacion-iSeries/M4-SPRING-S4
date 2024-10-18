package com.taller4.william.bancolombia.app.controlador;

import com.taller4.william.bancolombia.app.modelo.Cuenta;
import com.taller4.william.bancolombia.app.servicio.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/{id}/deposito")
    public ResponseEntity<Cuenta> depositar(@PathVariable Long id, @RequestParam BigDecimal monto) {
        try {
            Cuenta cuenta = cuentaService.realizarDeposito(id, monto);
            return ResponseEntity.ok(cuenta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{id}/retiro")
    public ResponseEntity<Cuenta> retirar(@PathVariable Long id, @RequestParam BigDecimal monto) {
        try {
            Cuenta cuenta = cuentaService.realizarRetiro(id, monto);
            return ResponseEntity.ok(cuenta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
