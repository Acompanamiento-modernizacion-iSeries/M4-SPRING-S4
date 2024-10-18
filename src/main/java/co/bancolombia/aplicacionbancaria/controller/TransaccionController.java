package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.dto.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.model.entity.Cuenta;
import co.bancolombia.aplicacionbancaria.service.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    /*private TransaccionService transaccioService;
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

     */
}
