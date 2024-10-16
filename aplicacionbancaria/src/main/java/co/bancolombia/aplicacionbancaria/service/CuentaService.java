package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.config.CuentaNoEncontradaException;
import co.bancolombia.aplicacionbancaria.model.DTO.CuentaDTO;
import co.bancolombia.aplicacionbancaria.model.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import co.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import co.bancolombia.aplicacionbancaria.model.Cuenta;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class CuentaService {

    private final CuentaRepository repository;
    private final TransaccionRepository transaccionRepository;

    public CuentaService(CuentaRepository repository, TransaccionRepository transaccionRepository) {
        this.repository = repository;
        this.transaccionRepository = transaccionRepository;
    }

    public BigDecimal obtenerSaldo(CuentaDTO cuentaDTO){
        Optional<Cuenta> cuentaEncontrada = repository.findById(cuentaDTO.getCuenta());
        if (cuentaEncontrada.isEmpty()){
            throw new CuentaNoEncontradaException(cuentaDTO.getCuenta());
        }
        return cuentaEncontrada.get().getSaldo();
    }

    public BigDecimal deposito(TransaccionDTO transaccionDTO) {
        Optional<Cuenta> cuentaEncontrada = repository.findById(transaccionDTO.getCuenta());
        if (cuentaEncontrada.isEmpty()) {
            throw new NoSuchElementException("La cuenta con ID " + transaccionDTO.getCuenta() + " no fue encontrada, intente con otro número de cuenta.");
        } else {
            if (transaccionDTO.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor que cero");
            } else {
                BigDecimal nuevoSaldo = transaccionDTO.getMonto().add(cuentaEncontrada.get().getSaldo());
                cuentaEncontrada.get().setSaldo(nuevoSaldo);
                return cuentaEncontrada.get().getSaldo();
            }
        }
    }

    public BigDecimal retiro(TransaccionDTO transaccionDTO) {
        Optional<Cuenta> cuentaEncontrada = repository.findById(transaccionDTO.getCuenta());
        if (cuentaEncontrada.isEmpty()) {
            throw new NoSuchElementException("La cuenta # " + transaccionDTO.getCuenta() + " no fue encontrada, intente con otro número de cuenta.");
        } else {
            if (transaccionDTO.getMonto().compareTo(cuentaEncontrada.get().getSaldo()) >= 0) {
                throw new IllegalStateException("No tiene saldo suficiente para realizar esta transacción.");
            } else {
                BigDecimal nuevoSaldo = cuentaEncontrada.get().getSaldo().subtract(transaccionDTO.getMonto());
                cuentaEncontrada.get().setSaldo(nuevoSaldo);
                return cuentaEncontrada.get().getSaldo();
            }
        }
    }
}