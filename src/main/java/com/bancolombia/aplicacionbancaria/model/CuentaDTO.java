package com.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public class CuentaDTO {

    @NotNull(message = "El número de cuenta no puede ser nulo...")
    @Positive(message = "El número de cuenta debe ser positivo...")
    @NotEmpty(message = "El número de cuenta no puede estar vacío...")
    private Long numeroCuenta;

    public CuentaDTO(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaDTO() {
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
