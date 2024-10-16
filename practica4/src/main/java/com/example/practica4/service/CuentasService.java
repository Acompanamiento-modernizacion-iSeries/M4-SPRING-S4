package com.example.practica4.service;

import com.example.practica4.model.Cuenta;
import com.example.practica4.model.Transaccion;
import com.example.practica4.repository.CuentaRepository;
import com.example.practica4.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CuentasService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    public void depositar(String numeroCuenta, BigDecimal monto) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            throw new RuntimeException("Cuenta no encontrada");
        }
        cuenta.setSaldo(cuenta.getSaldo().add(monto));


        Transaccion transaccion = new Transaccion();
        transaccion.setTipoTransaccion("deposito");
        transaccion.setMonto(monto);
        transaccion.setCuenta(cuenta);
        transaccion.setFecha(LocalDateTime.now());


        transaccionRepository.save(transaccion);
        cuentaRepository.save(cuenta);
    }

    public void retirar(String numeroCuenta, BigDecimal monto) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            throw new RuntimeException("Cuenta no encontrada");
        }
        if (cuenta.getSaldo().compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        cuenta.setSaldo(cuenta.getSaldo().subtract(monto));


        Transaccion transaccion = new Transaccion();
        transaccion.setTipoTransaccion("retiro");
        transaccion.setMonto(monto);
        transaccion.setCuenta(cuenta);
        transaccion.setFecha(LocalDateTime.now());

        transaccionRepository.save(transaccion);
        cuentaRepository.save(cuenta);
    }

    public BigDecimal consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
        if (cuenta == null) {
            throw new RuntimeException("Cuenta no encontrada");
        }
        return cuenta.getSaldo();
    }
}