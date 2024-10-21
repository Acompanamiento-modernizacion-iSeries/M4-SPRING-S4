package co.bancolombia.aplicacionbanco.service;

import co.bancolombia.aplicacionbanco.model.Cuenta;
import co.bancolombia.aplicacionbanco.model.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbanco.model.Transaccion;
import co.bancolombia.aplicacionbanco.repository.CuentaRepository;
import co.bancolombia.aplicacionbanco.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class transaccionService {
    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;
    LocalDateTime fechaHora = LocalDateTime.now();

    public transaccionService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    public Cuenta deposito(TransaccionDTO transaccion){
        Optional<Cuenta> cuentaExiste = cuentaRepository.findById(transaccion.getCuentaId());
        Cuenta infoCuenta = cuentaExiste.get();
        infoCuenta.setSaldo(infoCuenta.getSaldo().add(transaccion.getMonto()));
        Transaccion addRegistro = addTransaccion(infoCuenta, "Depósito", transaccion.getMonto());
        infoCuenta.getTransacciones().add(addRegistro);
        transaccionRepository.save(addRegistro);
        return infoCuenta;

    }

    public Cuenta retiro(TransaccionDTO transaccion){
        Optional<Cuenta> cuentaExiste = cuentaRepository.findById(transaccion.getCuentaId());
        Cuenta infoCuenta = cuentaExiste.get();
        if(infoCuenta.getSaldo().compareTo(transaccion.getMonto())<0)
            throw new IllegalArgumentException("Saldo es insuficiente para realizar el retiro");
        infoCuenta.setSaldo(infoCuenta.getSaldo().subtract(transaccion.getMonto()));
        Transaccion addRegistro = addTransaccion(infoCuenta, "Retiro", transaccion.getMonto() );
        infoCuenta.getTransacciones().add(addRegistro);
        transaccionRepository.save(addRegistro);
        return infoCuenta;

    }

    public Transaccion addTransaccion(Cuenta datosCuenta, String tipo_transaccion, BigDecimal monto) {
        Transaccion historial = new Transaccion(null,
                tipo_transaccion,
                monto,
                Timestamp.valueOf(fechaHora),
                datosCuenta);
        return historial;
    }
}
