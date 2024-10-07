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

    public BigDecimal obtenerSaldo(String id) {
        if (dbCuenta.obtenerCuenta(id) == null) {
            return null;
        }
        return dbCuenta.obtenerCuenta(id).getSaldo();
    }

    public String deposito(String id, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            if (dbCuenta.obtenerCuenta(id) == null) {
                return "La cuenta no existe.";
            }
            dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().add(monto));
            return "Depósito exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
        } else {
            return "El monto a depositar debe ser mayor a cero.";
        }
    }

    public String retiro(String id, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            if (dbCuenta.obtenerCuenta(id) == null) {
                return "La cuenta no existe.";
            }
            if (dbCuenta.obtenerCuenta(id).getSaldo().compareTo(monto) < 0) {
                return "Saldo insuficiente.";
            }
            dbCuenta.obtenerCuenta(id).setSaldo(dbCuenta.obtenerCuenta(id).getSaldo().subtract(monto));
            return "Retiro exitoso. Saldo actual: " + dbCuenta.obtenerCuenta(id).getSaldo();
        } else {
            return "El monto a retirar debe ser mayor a cero.";
        }
    }
}
