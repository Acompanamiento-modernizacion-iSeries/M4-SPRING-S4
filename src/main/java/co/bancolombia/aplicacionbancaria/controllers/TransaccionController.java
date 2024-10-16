package co.bancolombia.aplicacionbancaria.controllers;

import co.bancolombia.aplicacionbancaria.models.Cuenta;
import co.bancolombia.aplicacionbancaria.models.dto.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.services.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    private TransaccionService transaccioService;
    public TransaccionController(TransaccionService transaccioService) {
        this.transaccioService = transaccioService;
    }
    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        Cuenta datosCuenta = transaccioService.retiro(transaccionDTO);
        return "RETIRO EXITOSO!!!\n\n" + datosCuenta.toString();
    }
    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        Cuenta datosCuenta = transaccioService.deposito(transaccionDTO);
        return "DEPOSITO EXITOSO!!!\n\n" + datosCuenta.toString();
    }
}