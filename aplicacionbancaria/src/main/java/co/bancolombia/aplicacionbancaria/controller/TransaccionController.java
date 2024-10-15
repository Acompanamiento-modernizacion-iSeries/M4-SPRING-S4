package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.modelo.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.service.TransaccionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    private final TransaccionService transaccionService;

    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return transaccionService.depositar(transaccionDTO);
    }
    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        return transaccionService.retirar(transaccionDTO);
    }
}
