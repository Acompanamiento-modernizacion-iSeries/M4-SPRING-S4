package co.bancolombia.aplicacionbancaria.services;

import co.bancolombia.aplicacionbancaria.models.Cuenta;
import co.bancolombia.aplicacionbancaria.models.Transaccion;
import co.bancolombia.aplicacionbancaria.models.dto.BuscarCuentaDTO;
import co.bancolombia.aplicacionbancaria.models.dto.CrearCuentaDTO;
import co.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import co.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CuentaService {
    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;
    LocalDateTime currentTS = LocalDateTime.now();
    public CuentaService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }
    public Cuenta obtenerDatosCuenta(BuscarCuentaDTO cuenta){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(cuenta.getCuentaId());
        if(cuentaEncontrada == null){
            throw new NullPointerException("La cuenta:" + cuenta + " no existe");
        }
        Cuenta datosCuenta = cuentaEncontrada.get();
        return datosCuenta;
    }
    public Cuenta registroCuenta(CrearCuentaDTO registroCuenta){
        Cuenta nuevaCuenta = new Cuenta(null,
                registroCuenta.getTitular(),
                registroCuenta.getSaldo());
        Transaccion logHistoria = llenarTransaccion(nuevaCuenta, "Registro de cuenta", nuevaCuenta.getSaldo());
        nuevaCuenta.getTransacciones().add(logHistoria);
        nuevaCuenta = nuevaCuenta =cuentaRepository.save(nuevaCuenta);
        logHistoria.setCuenta(nuevaCuenta);
        transaccionRepository.save(logHistoria);
        if(nuevaCuenta.getIdCuenta() == null){
            throw new NullPointerException("Error en la creación de a cuenta");
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