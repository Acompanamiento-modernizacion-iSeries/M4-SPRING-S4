package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.model.Transaccion;
import co.bancolombia.aplicacionbancaria.service.TransaccionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //Depositar a una cuenta.
    @PostMapping("/deposito")
    public ResponseEntity<String> depositar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        Transaccion transaccion = transaccionService.depositar(transaccionDTO);
        String mensaje = String.format("Depósito realizado correctamente. Número de cuenta: %d, Nuevo saldo: %.2f",
                transaccion.consultarCuentaAsociada().consultarCuenta(), transaccion.consultarCuentaAsociada().consultarSaldo());
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    //Retirar de una cuenta.
    @PostMapping("/retiro")
    public ResponseEntity<String> retirar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        Transaccion transaccion = transaccionService.retirar(transaccionDTO);
        String mensaje = String.format("Retiro realizado correctamente. Número de cuenta: %d, Nuevo saldo: %.2f",
                transaccion.consultarCuentaAsociada().consultarCuenta(), transaccion.consultarCuentaAsociada().consultarSaldo());
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
}
