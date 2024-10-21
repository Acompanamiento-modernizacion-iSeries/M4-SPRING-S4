package co.bancolombia.aplicacionbanco.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import co.bancolombia.aplicacionbanco.model.Cuenta;
import co.bancolombia.aplicacionbanco.model.DTO.BuscarCuentaDTO;
import co.bancolombia.aplicacionbanco.model.DTO.IngresarCuentaDTO;
import co.bancolombia.aplicacionbanco.model.Transaccion;
import co.bancolombia.aplicacionbanco.repository.CuentaRepository;
import co.bancolombia.aplicacionbanco.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

@Service
public class cuentaService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;
    LocalDateTime fechaHora = LocalDateTime.now();

    public cuentaService(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;

    }

    public Cuenta obtenerInfoCuenta(BuscarCuentaDTO cuenta) {
        Optional<Cuenta> cuentaExiste = cuentaRepository.findById(cuenta.getCuentaId());
        if (cuentaExiste == null)
            throw new NullPointerException("El numero de cuenta no existe");
        Cuenta infoCuenta = cuentaExiste.get();
        return infoCuenta;
    }

    public Cuenta registrarCuenta(IngresarCuentaDTO cuenta) {
        Cuenta newCuenta = new Cuenta(null,
                cuenta.getSaldo());
        Transaccion addRegistro = addTransaccion(newCuenta, "Creacion de cuenta", newCuenta.getSaldo());
        newCuenta.getTransacciones().add(addRegistro);
        newCuenta = newCuenta = cuentaRepository.save(newCuenta);
        addRegistro.setCuenta(newCuenta);
        transaccionRepository.save(addRegistro);
        if (newCuenta.getCuentaId()== null)
            throw new NullPointerException("Error al registrar la cuenta");
        return newCuenta;
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












