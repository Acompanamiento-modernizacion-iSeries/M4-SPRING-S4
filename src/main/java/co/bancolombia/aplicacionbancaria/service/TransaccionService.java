package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.model.dto.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.model.entity.Cuenta;
import co.bancolombia.aplicacionbancaria.model.entity.Transaccion;
import co.bancolombia.aplicacionbancaria.repository.ICuentaRepository;
import co.bancolombia.aplicacionbancaria.repository.ITransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransaccionService {
    private final ICuentaRepository cuentaRepository;
    private final ITransaccionRepository transaccionRepository;
    LocalDateTime currentTS = LocalDateTime.now();

    public TransaccionService(ICuentaRepository cuentaRepository, ITransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

/*    public Cuenta deposito(TransaccionDTO transaccion){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(transaccion.getCuentaId());
        Cuenta datosCuenta = cuentaEncontrada.get();
        datosCuenta.setSaldo(datosCuenta.getSaldo().add(transaccion.getMonto()));
        Transaccion logHistoria = llenarTransaccion(datosCuenta, "Depósito", transaccion.getMonto());
        datosCuenta.getTransacciones().add(logHistoria);
        transaccionRepository.save(logHistoria);
        return datosCuenta;
    }*/

/*    public Cuenta retiro(TransaccionDTO transaccion){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(transaccion.getCuentaId());
        Cuenta datosCuenta = cuentaEncontrada.get();
        if(datosCuenta.getSaldo().compareTo(transaccion.getMonto())< 0){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        datosCuenta.setSaldo(datosCuenta.getSaldo().subtract(transaccion.getMonto()));
        Transaccion logHistoria = llenarTransaccion(datosCuenta, "Retiro", transaccion.getMonto());
        datosCuenta.getTransacciones().add(logHistoria);
        transaccionRepository.save(logHistoria);

        return datosCuenta;
    }*/
/*
    public Transaccion llenarTransaccion(Cuenta datosCuenta , String tipo_transaccion, BigDecimal monto){
        Transaccion historia = new Transaccion(null,
                tipo_transaccion,
                monto,
                Timestamp.valueOf(currentTS),
                datosCuenta);
        return historia;
    }*/
}