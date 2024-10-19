package co.com.coban.aplicacionbancaria.service;

import co.com.coban.aplicacionbancaria.entity.Cuenta;
import co.com.coban.aplicacionbancaria.entity.Transaccion;
import co.com.coban.aplicacionbancaria.repository.CuentaRepository;
import co.com.coban.aplicacionbancaria.repository.DbCuenta;
import co.com.coban.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final TransaccionRepository transaccionRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, TransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public BigDecimal obtenerSaldo(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("La cuenta identificada con el id " + id + " no existe :("));
        return cuenta.getSaldo();
    }

    @Override
    public String deposito(Long id, BigDecimal monto) {
        validarMonto(monto);
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("La cuenta no existe."));
        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        cuentaRepository.save(cuenta);

        Transaccion transaccion = new Transaccion();
        transaccion.setCuenta(cuenta);
        transaccion.setMonto(monto);
        transaccion.setFecha(LocalDateTime.now());
        transaccionRepository.save(transaccion);

        return "Depósito exitoso. Saldo actual: " + cuenta.getSaldo();
    }

    @Override
    public String retiro(Long id, BigDecimal monto) {
        validarMonto(monto);
        Cuenta cuenta = cuentaRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("La cuenta no existe."));
        if (cuenta.getSaldo().compareTo(monto) < 0) {
            return "Saldo insuficiente.";
        }
        cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
        cuentaRepository.save(cuenta);

        Transaccion transaccion = new Transaccion();
        transaccion.setCuenta(cuenta);
        transaccion.setMonto(monto.negate());
        transaccion.setFecha(LocalDateTime.now());
        transaccionRepository.save(transaccion);

        return "Retiro exitoso. Saldo actual: " + cuenta.getSaldo();
    }

    @Override
    public boolean validarCuenta(Long id) {
        return cuentaRepository.existsById(id);
    }

    @Override
    public void validarMonto(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
    }




//    private final DbCuenta dbCuenta;
//
//    private CuentaRepository cuentaRepository;
//
//    public CuentaServiceImpl(DbCuenta dbCuenta, CuentaRepository cuentaRepository) {
//        this.dbCuenta = dbCuenta;
//        this.cuentaRepository = cuentaRepository;
//    }
//
//    public BigDecimal obtenerSaldo(Long id) {
//        Cuenta cuenta = cuentaRepository.findById(id).isPresent() ? cuentaRepository.findById(id).get() : null;
//        if (cuenta == null) {
//            throw new IllegalArgumentException("La cuenta identificada con el id " + id + " no existe :(");
//        }
//        return cuenta.getSaldo();
//    }
//
//    public String deposito(Long id, BigDecimal monto) {
//        validarMonto(monto);
//        if(!validarCuenta(id)){
//            return "La cuenta no existe.";
//        }
//        dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().add(monto));
//        return "Depósito exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
//    }
//
//    public String retiro(Long id, BigDecimal monto) {
//        validarMonto(monto);
//        if (!validarCuenta(id)) {
//            return "La cuenta no existe.";
//        }
//        if (dbCuenta.obtenerCuenta(id).getSaldo().compareTo(monto) < 0) {
//            return "Saldo insuficiente.";
//        }
//        dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().subtract(monto));
//        return "Retiro exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
//    }
//
//    public boolean validarCuenta(Long id) {
//        return dbCuenta.obtenerCuenta(id) != null;
//    }
//
//    public void validarMonto(BigDecimal monto) {
//        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
//            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
//        }
//    }
}
