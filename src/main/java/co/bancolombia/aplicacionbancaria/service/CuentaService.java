package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.DB.CuentaDB;
import co.bancolombia.aplicacionbancaria.model.Cuenta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaService {

    private static CuentaDB cuentaDB;

    public CuentaService(CuentaDB cuentaDB){
        this.cuentaDB = cuentaDB;
    }

    private static Cuenta validarCuenta(String nroCuenta){
        if (!nroCuenta.matches("\\d+")) { // Verifica que todos los caracteres sean dígitos
            throw new IllegalStateException("Formato de cuenta invalido");
        }
        Cuenta cuenta = cuentaDB.buscarCuenta(nroCuenta);
        if (cuenta == null) {
            throw new NullPointerException("¡La cuenta no existe en el sistema!");
        }
        return cuenta;
    }

    private static void validarMonto(BigDecimal monto){
        if (monto.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalStateException("¡El monto debe ser mayor a cero!");
        }
    }

    private static void validarSaldoEnCuenta(Cuenta cuenta, BigDecimal monto){
        if (cuenta.consultarSaldo().compareTo(monto) <= 0) {
            throw new IllegalStateException("¡Saldo insuficiente!");
        }
    }

    public static String obtenerSaldo(String nroCuenta){
        Cuenta cuenta = validarCuenta(nroCuenta);
        return  "¡Consulta exitosa! " + consultaDataCuenta(cuenta);
    }

    public static String depositar(String nroCuenta, BigDecimal monto) {
        Cuenta cuenta = validarCuenta(nroCuenta);
        validarMonto(monto);
        cuenta.deposito(monto);
        return "¡Depósito exitoso! " + consultaDataCuenta(cuenta);
    }

    public static String retirar(String nroCuenta, BigDecimal monto) {
        Cuenta cuenta = validarCuenta(nroCuenta);
        validarMonto(monto);
        validarSaldoEnCuenta(cuenta, monto);
        cuenta.retiro(monto);
        return "¡Retiro exitoso! " + consultaDataCuenta(cuenta);
    }

    public static String consultaDataCuenta(Cuenta cuenta) {
        return    " \nNro. Cuenta : "  + cuenta.consultarCuenta()
                + " \nSaldo       : $" + cuenta.consultarSaldo();
    }
}
