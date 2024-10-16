package com.bancolombia.aplicacionbanco.service;

import com.bancolombia.aplicacionbanco.DTO.CuentaDTO;
import com.bancolombia.aplicacionbanco.DTO.TransaccionDTO;
import com.bancolombia.aplicacionbanco.model.Cuenta;
import com.bancolombia.aplicacionbanco.model.Transaccion;
import com.bancolombia.aplicacionbanco.repository.CuentaRepository;
import com.bancolombia.aplicacionbanco.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public CuentaService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository){
        this.cuentaRepository=cuentaRepository;
        this.transaccionRepository=transaccionRepository;
    }

    public BigDecimal obtenerSaldo(CuentaDTO cuentaDTO){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(cuentaDTO.getId());
        if (cuentaEncontrada.isEmpty()){
            throw new NoSuchElementException("La cuenta con ID "+cuentaDTO.getId()+" no fue encontrada. :C");
        }
        return cuentaEncontrada.get().getSaldo();
    }


    public BigDecimal depositar(TransaccionDTO transaccionDTO) {
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(transaccionDTO.getCuentaId());
        if (cuentaEncontrada.isEmpty()) {
            throw new NoSuchElementException("La cuenta con ID " + transaccionDTO.getCuentaId() + " no fue encontrada. :C");
        } else {
            if (transaccionDTO.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor que cero");
            } else {
                BigDecimal nuevoSaldo = transaccionDTO.getMonto().add(cuentaEncontrada.get().getSaldo());
                cuentaEncontrada.get().setSaldo(nuevoSaldo);
                //cuentaRepository.save(transaccionDTO)
                return cuentaEncontrada.get().getSaldo();
            }
        }
    }

    public BigDecimal retirar(TransaccionDTO transaccionDTO) {
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(transaccionDTO.getCuentaId());
        if (cuentaEncontrada.isEmpty()) {
            throw new NoSuchElementException("La cuenta con ID " + transaccionDTO.getCuentaId() + " no fue encontrada. :C");
        } else {
            if (transaccionDTO.getMonto().compareTo(cuentaEncontrada.get().getSaldo()) >= 0) {
                throw new IllegalStateException("Saldo insuficiente para este retiro");
            } else {
                BigDecimal nuevoSaldo = cuentaEncontrada.get().getSaldo().subtract(transaccionDTO.getMonto());
                cuentaEncontrada.get().setSaldo(nuevoSaldo);
                //cuentaRepository.save(transaccionDTO)
                return cuentaEncontrada.get().getSaldo();
            }
        }
    }
}
