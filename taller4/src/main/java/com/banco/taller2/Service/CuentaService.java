package com.banco.taller2.Service;

import com.banco.taller2.DTO.CuentaDTO;
import com.banco.taller2.DTO.TransaccionDTO;
import com.banco.taller2.Model.Cuenta;
import com.banco.taller2.Model.Transaccion;
import com.banco.taller2.Repository.CuentaRepository;
import com.banco.taller2.Repository.TransaccionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class CuentaService {

    private final CuentaRepository repository;
    private final TransaccionRepository transaccion;

    public CuentaService(CuentaRepository repository, TransaccionRepository transaccion){
        this.repository = repository;
        this.transaccion = transaccion;
    }

    public BigDecimal obtenerSaldo(CuentaDTO cuentaDTO){
        Optional<Cuenta> cuentaEncontrada = repository.findById(cuentaDTO.getId());
        if (cuentaEncontrada.isEmpty()){
            throw new NoSuchElementException("La cuenta con id: "
                    + cuentaDTO.getId()
                    + " No fue encontrada");

        }
        return cuentaEncontrada.get().getSaldo();
    }

    public void depositar(Long cuentaId, BigDecimal monto) {
        Cuenta cuenta = repository.findById(cuentaId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));

        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        repository.save(cuenta);

        Transaccion transacciones = new Transaccion("depósito", monto, LocalDateTime.now(), cuenta);
        transaccion.save(transacciones);
    }

    public void retirar(Long cuentaId, BigDecimal monto) {
        Cuenta cuenta = repository.findById(cuentaId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));

        if (cuenta.getSaldo().compareTo(monto) >= 0) {
            cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
            repository.save(cuenta);

            Transaccion transacciones = new Transaccion("retiro", monto, LocalDateTime.now(), cuenta);
            transaccion.save(transacciones);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }


}
