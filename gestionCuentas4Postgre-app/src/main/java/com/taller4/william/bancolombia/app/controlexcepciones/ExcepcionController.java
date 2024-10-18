package com.taller4.william.bancolombia.app.controlexcepciones;

import com.taller4.william.bancolombia.app.excepciones.ExcepcionesPersonalizadas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepcionController {

    @ExceptionHandler(ExcepcionesPersonalizadas.DepositoInvalidoExcepcion.class)
    public ResponseEntity<String> handleDepositoInvalidoException(ExcepcionesPersonalizadas.DepositoInvalidoExcepcion ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExcepcionesPersonalizadas.SaldoInsuficienteExcepcion.class)
    public ResponseEntity<String> handleSaldoInsuficienteException(ExcepcionesPersonalizadas.SaldoInsuficienteExcepcion ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExcepcionesPersonalizadas.CuentaNoEncontradaExcepcion.class)
    public ResponseEntity<String> handleCuentaNoEncontradaException(ExcepcionesPersonalizadas.CuentaNoEncontradaExcepcion ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
