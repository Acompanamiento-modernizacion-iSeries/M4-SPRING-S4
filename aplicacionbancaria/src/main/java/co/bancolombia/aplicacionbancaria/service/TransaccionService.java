package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.model.Cuenta;
import co.bancolombia.aplicacionbancaria.model.Transaccion;
import co.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import co.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.NoSuchElementException;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;

    public TransaccionService(TransaccionRepository repository, CuentaRepository cuentaRepository) {
        this.transaccionRepository = repository;
        this.cuentaRepository = cuentaRepository;
    }

    @Transactional
    public Transaccion depositar(TransaccionDTO transaccionDTO) {
        Cuenta cuenta = cuentaRepository.findById(transaccionDTO.consultarCuentaAsociada())
                .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada"));

        cuenta.deposito(transaccionDTO.consultarValor());
        Transaccion transaccion = new Transaccion();
        transaccion.asignarCuentaAsociada(cuenta);
        transaccion.asignarTipoTransaccion("Depósito");
        transaccion.asignarValor(transaccionDTO.consultarValor());
        transaccion.asignarFecha(LocalDate.now());
        transaccion.asignarHora(LocalTime.now());

        return transaccionRepository.save(transaccion);
    }

    @Transactional
    public Transaccion retirar(TransaccionDTO transaccionDTO) {
        Cuenta cuenta = cuentaRepository.findById(transaccionDTO.consultarCuentaAsociada())
                .orElseThrow(() -> new NoSuchElementException("Cuenta no encontrada"));

        if (cuenta.consultarSaldo().compareTo(transaccionDTO.consultarValor()) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro");
        }

        cuenta.retiro(transaccionDTO.consultarValor());
        Transaccion transaccion = new Transaccion();
        transaccion.asignarCuentaAsociada(cuenta);
        transaccion.asignarTipoTransaccion("Retiro");
        transaccion.asignarValor(transaccionDTO.consultarValor());
        transaccion.asignarFecha(LocalDate.now());
        transaccion.asignarHora(LocalTime.now());

        return transaccionRepository.save(transaccion);
    }
}



