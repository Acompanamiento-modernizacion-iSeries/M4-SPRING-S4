package com.bancolombia.sistemabancario.sistemabancario.services;


import com.bancolombia.sistemabancario.sistemabancario.models.Cuenta;
import com.bancolombia.sistemabancario.sistemabancario.models.DTO.ConsultaPorCuentaDTO;
import com.bancolombia.sistemabancario.sistemabancario.models.DTO.TransaccionDTO;
import com.bancolombia.sistemabancario.sistemabancario.models.Transaccion;
import com.bancolombia.sistemabancario.sistemabancario.repository.CuentaRepository;
import com.bancolombia.sistemabancario.sistemabancario.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {
    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;
    LocalDateTime currentTS = LocalDateTime.now();

    public TransaccionService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    public Cuenta deposito(TransaccionDTO transaccion){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(transaccion.getCuentaId());
        Cuenta datosCuenta = cuentaEncontrada.get();
        datosCuenta.setSaldo(datosCuenta.getSaldo().add(transaccion.getMonto()));
        Transaccion logHistoria = llenarTransaccion(datosCuenta, "Depósito", transaccion.getMonto());
        datosCuenta.getTransacciones().add(logHistoria);
        transaccionRepository.save(logHistoria);
        return datosCuenta;
    }

    public Cuenta retiro(TransaccionDTO transaccion){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(transaccion.getCuentaId());
        Cuenta datosCuenta = cuentaEncontrada.get();
        if(datosCuenta.getSaldo().compareTo(transaccion.getMonto())< 0){
            throw new IllegalArgumentException("El saldo es insuficiente para realizar el retiro");
        }
        datosCuenta.setSaldo(datosCuenta.getSaldo().subtract(transaccion.getMonto()));
        Transaccion logHistoria = llenarTransaccion(datosCuenta, "Retiro", transaccion.getMonto());
        datosCuenta.getTransacciones().add(logHistoria);
        transaccionRepository.save(logHistoria);

        return datosCuenta;
    }

    public Transaccion llenarTransaccion(Cuenta datosCuenta , String tipo_transaccion, BigDecimal monto){
        Transaccion historia = new Transaccion(null,
                tipo_transaccion,
                monto,
                Timestamp.valueOf(currentTS),
                datosCuenta);
        return historia;
    }
}
