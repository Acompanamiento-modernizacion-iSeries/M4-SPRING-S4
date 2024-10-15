package com.bancolombia.sistemabancario.sistemabancario.services;

import com.bancolombia.sistemabancario.sistemabancario.models.Cuenta;
import com.bancolombia.sistemabancario.sistemabancario.models.DTO.ConsultaPorCuentaDTO;
import com.bancolombia.sistemabancario.sistemabancario.models.DTO.RegistrarCuentaDTO;
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
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository historiaRepository;
    LocalDateTime currentTS = LocalDateTime.now();


    public CuentaService(CuentaRepository cuentaRepository, TransaccionRepository historiaRepository) {
        this.cuentaRepository = cuentaRepository;
        this.historiaRepository = historiaRepository;
    }


    public Cuenta obtenerDatosCuenta(ConsultaPorCuentaDTO cuenta){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(cuenta.getCuentaId());
        if(cuentaEncontrada == null){
            throw new NullPointerException("La cuenta:" + cuenta + " no existe en el sistema");
        }
        Cuenta datosCuenta = cuentaEncontrada.get();
        return datosCuenta;
    }


    public Cuenta registroCuenta(RegistrarCuentaDTO registroCuenta){
        Cuenta nuevaCuenta = new Cuenta(null,
                registroCuenta.getTitular(),
                registroCuenta.getSaldo());
        Transaccion logHistoria = llenarTransaccion(nuevaCuenta, "Registro de cuenta", nuevaCuenta.getSaldo());
        nuevaCuenta.getTransacciones().add(logHistoria);
        nuevaCuenta = nuevaCuenta =cuentaRepository.save(nuevaCuenta);
        logHistoria.setCuenta(nuevaCuenta);
        historiaRepository.save(logHistoria);
        if(nuevaCuenta.getIdCuenta() == null){
            throw new NullPointerException("Error al registrar la cuenta");
        }

        return nuevaCuenta;
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
