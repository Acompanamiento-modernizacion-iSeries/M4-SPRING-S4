package co.bancolombia.aplicacionbanco.controller;

import co.bancolombia.aplicacionbanco.model.Cuenta;
import co.bancolombia.aplicacionbanco.model.DTO.TransaccionDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.bancolombia.aplicacionbanco.service.transaccionService;

@RestController
@RequestMapping("/Transaccion")
public class transaccionController {
    private transaccionService transaccionservice;
    public transaccionController(transaccionService transaccionservice){
        this.transaccionservice = transaccionservice;
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccion) {
        Cuenta infoCuenta = transaccionservice.deposito(transaccion);
        return "Repósito realizado con exito\n" + infoCuenta.toString();
    }

    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccion) {
        Cuenta infoCuenta = transaccionservice.retiro(transaccion);
        return "Retiro realizado con exito\n" + infoCuenta.toString();
    }

}
