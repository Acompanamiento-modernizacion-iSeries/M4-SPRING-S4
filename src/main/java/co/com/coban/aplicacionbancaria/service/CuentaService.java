package co.com.coban.aplicacionbancaria.service;

import co.com.coban.aplicacionbancaria.repository.DbCuenta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {
    private DbCuenta dbCuenta;

    public CuentaService(DbCuenta dbCuenta) {
        this.dbCuenta = dbCuenta;
    }

    public String obtenerSaldo(String id) {
        if (dbCuenta.obtenerCuenta(id) == null) {
            throw new IllegalArgumentException("La cuenta no existe.");
        }
        return "El saldo de la cuenta es: " + dbCuenta.obtenerCuenta(id).getSaldo();
    }

    public String deposito(String id, BigDecimal monto) {
        validarMonto(monto);
        if(!validarCuenta(id)){
            return "La cuenta no existe.";
        }
        dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().add(monto));
        return "Depósito exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
    }

    public String retiro(String id, BigDecimal monto) {
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

    public boolean validarCuenta(String id) {
        return dbCuenta.obtenerCuenta(id) != null;
    }

    public void validarMonto(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
    }
}
