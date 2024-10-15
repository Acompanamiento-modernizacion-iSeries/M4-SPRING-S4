package com.bancolombia.sistemabancario.sistemabancario.models.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class RegistrarCuentaDTO {


    @NotNull(message = "Debe ingresar la identificación del titular")
    @Positive(message = "La identificación debe ser mayor a cero")
    private Integer titular;

    @NotNull(message = "Debe ingresar el saldo")
    @Positive(message = "El saldo debe ser mayor a cero")
    private BigDecimal saldo;

    public RegistrarCuentaDTO() {
    }

    public RegistrarCuentaDTO(Integer titular, BigDecimal saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }


    public Integer getTitular() {
        return titular;
    }

    public void setTitular(Integer titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
