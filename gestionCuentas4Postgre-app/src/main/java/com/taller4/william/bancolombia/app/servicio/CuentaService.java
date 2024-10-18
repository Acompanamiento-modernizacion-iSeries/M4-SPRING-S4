package com.taller4.william.bancolombia.app.servicio;


import com.taller4.william.bancolombia.app.modelo.Cuenta;
import com.taller4.william.bancolombia.app.modelo.Transaccion;
import com.taller4.william.bancolombia.app.repository.CuentaRepository;
import com.taller4.william.bancolombia.app.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Transactional
    public Cuenta realizarDeposito(Long cuentaId, BigDecimal monto) throws Exception {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() -> new Exception("Cuenta no encontrada"));

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("El monto del depósito debe ser mayor a 0");
        }

        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        Transaccion transaccion = new Transaccion();
        transaccion.setTipo("DEPOSITO");
        transaccion.setMonto(monto);
        transaccion.setFecha(LocalDateTime.now());
        cuenta.agregarTransaccion(transaccion);

        transaccionRepository.save(transaccion);
        return cuentaRepository.save(cuenta);
    }

    @Transactional
    public Cuenta realizarRetiro(Long cuentaId, BigDecimal monto) throws Exception {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() -> new Exception("Cuenta no encontrada"));

        if (monto.compareTo(BigDecimal.ZERO) <= 0 || cuenta.getSaldo().compareTo(monto) < 0) {
            throw new Exception("Saldo insuficiente o monto inválido");
        }

        cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
        Transaccion transaccion = new Transaccion();
        transaccion.setTipo("RETIRO");
        transaccion.setMonto(monto);
        transaccion.setFecha(LocalDateTime.now());
        cuenta.agregarTransaccion(transaccion);

        transaccionRepository.save(transaccion);
        return cuentaRepository.save(cuenta);
    }
}