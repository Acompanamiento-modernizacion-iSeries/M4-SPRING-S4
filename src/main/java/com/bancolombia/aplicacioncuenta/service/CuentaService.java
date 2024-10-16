
package com.bancolombia.aplicacioncuenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancolombia.aplicacioncuenta.model.Cuenta;
import com.bancolombia.aplicacioncuenta.model.Transaccion;
import com.bancolombia.aplicacioncuenta.model.DTO.CuentaDTO;
import com.bancolombia.aplicacioncuenta.repository.CuentaRepository;
import com.bancolombia.aplicacioncuenta.repository.CuentasDB;
import com.bancolombia.aplicacioncuenta.repository.TransaccionRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private final CuentaRepository repository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    public CuentaService(CuentaRepository repository) {
        this.repository = repository;
    }

    public BigDecimal obtenerSaldo(String idCuenta) {
        Optional<Cuenta> cuentaEncontrada = repository.findById(Long.valueOf(idCuenta));
        if (!cuentaEncontrada.isPresent()) {
            throw new NoSuchElementException("La cuenta con id " + idCuenta + " no existe");
        }
        return cuentaEncontrada.get().getSaldo();
    }

    public BigDecimal depositar(String idCuenta, BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero");
        }
        Cuenta cuenta = buscarCuentaPorId(idCuenta);
        BigDecimal nuevoSaldo = cuenta.getSaldo().add(monto);
        cuenta.setSaldo(nuevoSaldo);

        Transaccion deposito = new Transaccion();
        deposito.setTipo(Transaccion.TipoTransaccion.DEPOSITO);
        deposito.setMonto(monto);
        deposito.setCuenta(cuenta);
        cuenta.getTransacciones().add(deposito);

        repository.save(cuenta);
        transaccionRepository.save(deposito);

        return nuevoSaldo;
    }

    public BigDecimal retirar(String idCuenta, BigDecimal monto) {
        if (monto == null) {
            throw new IllegalArgumentException("El monto no puede ser nulo");
        }
        Cuenta cuenta = buscarCuentaPorId(idCuenta);
        if (monto.compareTo(cuenta.getSaldo()) > 0) {
            throw new IllegalStateException("Saldo insuficiente para ese retiro");
        }
        
        BigDecimal nuevoSaldo = cuenta.getSaldo().subtract(monto);
        cuenta.setSaldo(nuevoSaldo);
        repository.save(cuenta);

        Transaccion retiro = new Transaccion();
        retiro.setTipo(Transaccion.TipoTransaccion.RETIRO);
        retiro.setMonto(monto);
        retiro.setCuenta(cuenta);
        transaccionRepository.save(retiro);
        repository.save(cuenta);

        return nuevoSaldo;
    }

    private Cuenta buscarCuentaPorId(String idCuenta) {
        Optional<Cuenta> cuenta = repository.findById(Long.valueOf(idCuenta));

        if (cuenta.isEmpty()) {
            throw new IllegalArgumentException("Cuenta no encontrada con ID: " + idCuenta);
        }

        return cuenta.get();
    }

    public List<Cuenta> obtenerTodasLasCuentas() {
        return CuentasDB.cuentas;
    }
}
