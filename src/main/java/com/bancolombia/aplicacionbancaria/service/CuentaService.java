package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.cuenta.Cuenta;
import com.bancolombia.aplicacionbancaria.cuenta.CuentaRepository;
import com.bancolombia.aplicacionbancaria.transaccion.Transaccion;
import com.bancolombia.aplicacionbancaria.transaccion.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public CuentaService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    public double consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = cuentaRepository.findById(numeroCuenta)
                .orElseThrow(() -> new NullPointerException("Cuenta no encontrada"));
        return cuenta.getSaldo();
    }

    public void depositar(String numeroCuenta, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero");
        }
        Cuenta cuenta = cuentaRepository.findById(numeroCuenta)
                .orElseThrow(() -> new NullPointerException("Cuenta no encontrada"));
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        Transaccion transaccion = new Transaccion("depósito", monto, LocalDateTime.now(), cuenta);
        cuenta.agregarTransaccion(transaccion);
        transaccionRepository.save(transaccion);
        cuentaRepository.save(cuenta);
    }

    public void retirar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentaRepository.findById(numeroCuenta)
                .orElseThrow(() -> new NullPointerException("Cuenta no encontrada"));
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero");
        }
        if (cuenta.getSaldo() < monto) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        Transaccion transaccion = new Transaccion("retiro", monto, LocalDateTime.now(), cuenta);
        cuenta.agregarTransaccion(transaccion);
        transaccionRepository.save(transaccion);
        cuentaRepository.save(cuenta);
    }
}


