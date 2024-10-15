package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.modelo.CuentaBanco;
import co.bancolombia.aplicacionbancaria.modelo.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.modelo.Transaccion;
import co.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import co.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TransaccionService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;


    public String depositar(TransaccionDTO transaccionDTO) {

        CuentaBanco cuenta = cuentaRepository.findByNroCuenta(transaccionDTO.getIdCuenta())
                .orElseThrow(() -> new NoSuchElementException("La cuenta con ID " + transaccionDTO.getIdCuenta() + " no fue encontrada"));

        validarMonto(cuenta.getSaldo(), transaccionDTO.getMonto());
        cuenta.setSaldo(cuenta.getSaldo().add(transaccionDTO.getMonto()));
        cuentaRepository.save(cuenta);

        Transaccion transaccion = buildtransaccion(transaccionDTO, "Deposito", cuenta);

        transaccionRepository.save(transaccion);

        return "¡Depósito exitoso! sobre cuenta número: " + transaccionDTO.getIdCuenta() + " Nuevo saldo: $" + cuenta.getSaldo();
    }

    private Transaccion buildtransaccion(TransaccionDTO transaccionDTO, String Tipo, CuentaBanco cuenta) {
        return Transaccion.builder()
                .tipoTransaccion(Tipo)
                .cuentaAsociada(cuenta)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .valor(transaccionDTO.getMonto())
                .build();
    }

    public String retirar(TransaccionDTO transaccionDTO) {
        CuentaBanco cuenta = cuentaRepository.findByNroCuenta(transaccionDTO.getIdCuenta())
                .orElseThrow(() -> new NoSuchElementException("La cuenta con ID " + transaccionDTO.getIdCuenta() + " no fue encontrada"));

        validarMonto(cuenta.getSaldo(), transaccionDTO.getMonto());
        cuenta.setSaldo(cuenta.getSaldo().subtract(transaccionDTO.getMonto()));
        cuentaRepository.save(cuenta);

        Transaccion transaccion = buildtransaccion(transaccionDTO, "Retiro", cuenta);

        transaccionRepository.save(transaccion);

        return "¡Retiro exitoso! "+ "sobre cuenta número: "+transaccionDTO.getIdCuenta()+" Nuevo saldo: $" + cuenta.getSaldo();
    }

    private void validarMonto(BigDecimal saldo, BigDecimal monto) {
        if (saldo.compareTo(monto) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar retiro");
        }
    }
}
