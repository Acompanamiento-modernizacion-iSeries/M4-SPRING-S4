package com.bancolombia.cuentabancaria.controller;

import com.bancolombia.cuentabancaria.model.entity.CuentaBancariaEntity;
import com.bancolombia.cuentabancaria.model.exception.DomainException;
import com.bancolombia.cuentabancaria.model.request.CuentaBancariaRQ;
import com.bancolombia.cuentabancaria.model.request.TransaccionRQ;
import com.bancolombia.cuentabancaria.service.CuentaBancariaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/cuenta")
public class CuentaBancariaController {

    private final CuentaBancariaService cuentaBancariaService;

    public CuentaBancariaController(CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaService = cuentaBancariaService;
    }

    @PostMapping(path = "/saldo")
    public ResponseEntity<Object> saldo(@Valid @RequestBody CuentaBancariaRQ cuentaBancariaRQ) throws DomainException {
        Map<String, Object> message = new HashMap<>();
        message.put("saldo", cuentaBancariaService.getCuenta(cuentaBancariaRQ.getIdCuenta()).getSaldo());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(path = "/deposito")
    public ResponseEntity<Object> deposito(@Valid @RequestBody TransaccionRQ transaccionRQ)
            throws DomainException {
        Map<String, Object> message = new HashMap<>();
        CuentaBancariaEntity cuentaEntity = cuentaBancariaService.getCuenta(transaccionRQ.getIdCuenta());
        if(!cuentaBancariaService.validSaldo(transaccionRQ.getValor())){
            message.put("message", "El valor no puede ser negativo");
        }else{
            cuentaEntity.setSaldo(cuentaEntity.getSaldo().add(transaccionRQ.getValor()));
            cuentaBancariaService.updateCuentaBancaria(cuentaEntity, "deposito", transaccionRQ.getValor());
            message.put("message", "Deposito exitoso");
            message.put("saldo", cuentaEntity.getSaldo());
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping(path = "/retiro")
    public ResponseEntity<Object> retiro(@Validated @RequestBody TransaccionRQ transaccionRQ)
            throws DomainException {
        Map<String, Object> message = new HashMap<>();
        CuentaBancariaEntity cuentaEntity = cuentaBancariaService.getCuenta(transaccionRQ.getIdCuenta());
        if(!cuentaBancariaService.validSaldo(transaccionRQ.getValor())){
            message.put("message", "El valor no puede ser negativo");
        }else{
            cuentaEntity.setSaldo(cuentaEntity.getSaldo().subtract(transaccionRQ.getValor()));
            cuentaBancariaService.updateCuentaBancaria(cuentaEntity, "retiro", transaccionRQ.getValor());
            message.put("message", "Retiro exitoso");
            message.put("saldo", cuentaEntity.getSaldo());
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
