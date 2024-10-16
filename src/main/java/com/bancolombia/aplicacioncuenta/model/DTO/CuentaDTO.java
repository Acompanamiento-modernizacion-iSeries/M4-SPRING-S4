package com.bancolombia.aplicacioncuenta.model.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;

public class CuentaDTO {

    @NotEmpty(message = "El id de la cuenta no puede estar vacío")
    private Long id;

    private BigDecimal saldo;

    @NotEmpty(message = "El titular de la cuenta no puede estar vacío")
    private String titular;

    public CuentaDTO(Long id, BigDecimal saldo, String titular) {
        this.id = id;
        this.saldo = saldo;
        this.titular = titular;
    }

    public CuentaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "CuentaDTO { " +
                "id=" + id +
                ", saldo=" + saldo +
                ", titular='" + titular + '\'' +
                " }";
    }
}