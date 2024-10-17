package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.model.Transaccion;
import co.bancolombia.aplicacionbancaria.service.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService){
        this.transaccionService = transaccionService;
    }

    @PostMapping("/deposito")
    public Transaccion depositar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return transaccionService.depositar(transaccionDTO);
    }

    @PostMapping("/retiro")
    public Transaccion retirar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return transaccionService.retirar(transaccionDTO);
    }
}
