package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.TransaccionCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.TransaccionCuentaMontoDTO;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public String obtenerSaldo(@Valid @RequestBody TransaccionCuentaDTO trx) {
        System.out.println(trx.toString());
        return cuentaService.obtenerSaldo(trx.getCuentaID());
    }

    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionCuentaMontoDTO trx) {
        System.out.println(trx.toString());
        return cuentaService.depositar(trx.getCuentaID(), trx.getMonto());
    }

    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionCuentaMontoDTO trx) {
        System.out.println(trx.toString());
        return cuentaService.retirar(trx.getCuentaID(), trx.getMonto());
    }
}
