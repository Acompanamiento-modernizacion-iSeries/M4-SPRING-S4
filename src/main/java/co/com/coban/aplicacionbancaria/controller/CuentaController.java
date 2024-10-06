package co.com.coban.aplicacionbancaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private BigDecimal saldo = new BigDecimal("1000.00");

    @GetMapping("/bienvenido")
    public String bienvenido() {
        return "Bienvenido, en esta sección podrá realizar operaciones con su cuenta.";
    }

    @GetMapping("/saldo")
    public BigDecimal saldo() {
        return saldo;
    }

    @PostMapping("/deposito/{monto}")
    public String deposito(@PathVariable BigDecimal monto) {
//        saldo = saldo.add(monto);
//        return saldo;
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(monto);
            return "Depósito exitoso. Saldo actual: " + saldo;
        } else {
//            return new BigDecimal("-1");
            return "El monto a depositar debe ser mayor a cero.";
        }
    }

    @PostMapping("/deposito2/{monto}")
    public String deposito2(@RequestParam("monto") BigDecimal valor) {
//        saldo = saldo.add(monto);
//        return saldo;
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
            return "Depósito exitoso. Saldo actual: " + saldo;
        } else {
//            return new BigDecimal("-1");
            return "El monto a depositar debe ser mayor a cero.";
        }
    }

}
