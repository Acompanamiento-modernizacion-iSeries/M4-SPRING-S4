package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.model.Cuenta;
import com.bancolombia.aplicacionbancaria.model.CuentaDTO;
import com.bancolombia.aplicacionbancaria.model.DepositoDTO;
import com.bancolombia.aplicacionbancaria.model.RetiroDTO;
import com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public BigDecimal obtenerSaldo(CuentaDTO cuentaDTO) {
        Cuenta cuenta = cuentaRepository.findById(cuentaDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        return cuenta.getSaldo();
    }

    public BigDecimal depositar(DepositoDTO depositoDTODTO) {
        if (depositoDTODTO.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        }
        Cuenta cuenta = cuentaRepository.findById(depositoDTODTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        cuenta.setSaldo(cuenta.getSaldo().add(depositoDTODTO.getMonto()));
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }


    public BigDecimal retirar(RetiroDTO retiroDTO) {
        Cuenta cuenta = cuentaRepository.findById(retiroDTO.getNumeroCuenta())
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));
        if (retiroDTO.getMonto().compareTo(cuenta.getSaldo()) > 0) {
            throw new IllegalStateException("Saldo insuficiente para realizar el retiro");
        }
        cuenta.setSaldo(cuenta.getSaldo().subtract(retiroDTO.getMonto()));
        cuentaRepository.save(cuenta);
        return cuenta.getSaldo();
    }


}
