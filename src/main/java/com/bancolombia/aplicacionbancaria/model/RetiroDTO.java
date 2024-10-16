package com.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class RetiroDTO {

    @NotNull(message = "El monto no puede ser nulo...")
    @Min(value = 1, message = "El monto debe ser mayor a cero...")
    private BigDecimal monto;

    @NotNull(message = "El número de cuenta no puede ser nulo...")
    @Positive(message = "El número de cuenta debe ser positivo...")
    @NotEmpty(message = "El número de cuenta no puede estar vacío...")
    private Long numeroCuenta;

    public RetiroDTO() {
    }

    public RetiroDTO(BigDecimal monto, Long numeroCuenta) {
        this.monto = monto;
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
