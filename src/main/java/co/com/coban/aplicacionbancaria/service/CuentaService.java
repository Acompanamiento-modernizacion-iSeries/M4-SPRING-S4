package co.com.coban.aplicacionbancaria.service;

import co.com.coban.aplicacionbancaria.entity.Cuenta;
import co.com.coban.aplicacionbancaria.repository.CuentaRepository;
import co.com.coban.aplicacionbancaria.repository.DbCuenta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {
    private final DbCuenta dbCuenta;

    private CuentaRepository cuentaRepository;

    public CuentaService(DbCuenta dbCuenta, CuentaRepository cuentaRepository) {
        this.dbCuenta = dbCuenta;
        this.cuentaRepository = cuentaRepository;
    }

    public BigDecimal obtenerSaldo(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).isPresent() ? cuentaRepository.findById(id).get() : null;
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta identificada con el id " + id + " no existe :(");
        }
        return cuenta.getSaldo();
    }

    public String deposito(Long id, BigDecimal monto) {
        validarMonto(monto);
        if(!validarCuenta(id)){
            return "La cuenta no existe.";
        }
        dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().add(monto));
        return "Depósito exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
    }

    public String retiro(Long id, BigDecimal monto) {
        validarMonto(monto);
        if (!validarCuenta(id)) {
            return "La cuenta no existe.";
        }
        if (dbCuenta.obtenerCuenta(id).getSaldo().compareTo(monto) < 0) {
            return "Saldo insuficiente.";
        }
        dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().subtract(monto));
        return "Retiro exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
    }

    public boolean validarCuenta(Long id) {
        return dbCuenta.obtenerCuenta(id) != null;
    }

    public void validarMonto(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
    }
}
