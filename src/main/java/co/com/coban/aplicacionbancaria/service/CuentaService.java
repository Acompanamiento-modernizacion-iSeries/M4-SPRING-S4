package co.com.coban.aplicacionbancaria.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface CuentaService {
    BigDecimal obtenerSaldo(Long id);

    String deposito(Long id, BigDecimal monto);

    String retiro(Long id, BigDecimal monto);

    boolean validarCuenta(Long id);

    void validarMonto(BigDecimal monto);
}
