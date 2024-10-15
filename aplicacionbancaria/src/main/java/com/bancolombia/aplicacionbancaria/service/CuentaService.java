package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.config.CuentaInvalidaException;
import com.bancolombia.aplicacionbancaria.config.MontoInvalidoException;
import com.bancolombia.aplicacionbancaria.config.SaldoInsuficienteException;
import com.bancolombia.aplicacionbancaria.entity.Cuenta;
import com.bancolombia.aplicacionbancaria.entity.TransaccionDTO;
import com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import com.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    public BigDecimal consultarSaldo(Long numeroCuenta) {
        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(numeroCuenta);
        if (!cuentaOpt.isPresent()) {
            throw new CuentaInvalidaException();
        }
        return cuentaOpt.get().getSaldo();
    }

    @Transactional
    public void depositar(Long idCuenta, BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new MontoInvalidoException();
        }

        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(idCuenta);
        if (!cuentaOpt.isPresent()) {
            throw new CuentaInvalidaException();
        }

        Cuenta cuenta = cuentaOpt.get();
        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        registrarTransaccion(cuenta, monto, "DEPOSITO");
        cuentaRepository.save(cuenta);


    }

    private void registrarTransaccion(Cuenta cuenta, BigDecimal monto, String tipo) {
        TransaccionDTO transaccion = new TransaccionDTO();
        transaccion.setTipo(tipo);
        transaccion.setMonto(monto);
        transaccion.setFecha(LocalDateTime.now());
        cuenta.agregarTransaccion(transaccion);

        transaccionRepository.save(transaccion);
    }

    @Transactional
    public void  retirar(Long idCuenta, BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new MontoInvalidoException();
        }

        Optional<Cuenta> cuentaOpt = cuentaRepository.findById(idCuenta);
        if (!cuentaOpt.isPresent()) {
            throw new CuentaInvalidaException();
        }

        Cuenta cuenta = cuentaOpt.get();
        if (cuenta.getSaldo().compareTo(monto) < 0) {
            throw new SaldoInsuficienteException();
        }

        cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
        cuentaRepository.save(cuenta);
        registrarTransaccion(cuenta, monto, "RETIRO");

    }


}
