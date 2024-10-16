package com.example.practica4.model.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CuentaDTO {

    @NotEmpty (message = "Por favor ingresar el numero de la cuenta.")
    private String numeroCuenta;

    @NotNull(message = "Se debe ingresar un monto.")
    private BigDecimal monto;


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
