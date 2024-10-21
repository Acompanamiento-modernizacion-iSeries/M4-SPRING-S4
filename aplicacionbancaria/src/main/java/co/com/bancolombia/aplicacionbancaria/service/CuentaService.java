package co.com.bancolombia.aplicacionbancaria.service;

import co.com.bancolombia.aplicacionbancaria.config.CuentaException;
import co.com.bancolombia.aplicacionbancaria.model.DTO.CuentaDTO;
import co.com.bancolombia.aplicacionbancaria.model.DTO.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import co.com.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import co.com.bancolombia.aplicacionbancaria.model.Cuenta;

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
            throw new CuentaException(cuentaDTO.getCuenta());
        }
        return cuentaEncontrada.get().getSaldo();
    }

    public BigDecimal deposito(TransaccionDTO transaccionDTO) {
        Optional<Cuenta> cuentaEncontrada = repository.findById(transaccionDTO.getCuenta());
        if (cuentaEncontrada.isEmpty()) {
            throw new NoSuchElementException("La cuenta con ID " + transaccionDTO.getCuenta() + " no se encontró. Por favor, verifique el número de cuenta e intente de nuevo.");
        } else {
            if (transaccionDTO.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("El monto debe ser un valor positivo mayor que cero.");
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
            throw new NoSuchElementException("La cuenta con ID " + transaccionDTO.getCuenta() + " no se encontró. Por favor, verifique el número de cuenta e intente de nuevo.");
        } else {
            if (transaccionDTO.getMonto().compareTo(cuentaEncontrada.get().getSaldo()) >= 0) {
                throw new IllegalStateException("Saldo insuficiente para realizar esta transacción. Su saldo actual es de " + cuentaEncontrada.get().getSaldo() + ".");
            } else {
                BigDecimal nuevoSaldo = cuentaEncontrada.get().getSaldo().subtract(transaccionDTO.getMonto());
                cuentaEncontrada.get().setSaldo(nuevoSaldo);
                return cuentaEncontrada.get().getSaldo();
            }
        }
    }
}
