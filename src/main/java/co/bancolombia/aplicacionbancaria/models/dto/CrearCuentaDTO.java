package co.bancolombia.aplicacionbancaria.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class CrearCuentaDTO {
    @NotNull(message = "titular - El nombre del titular esta vacio")
    @Positive(message = "titular - El dato ingresado es invalido")
    private Integer titular;

    @NotNull(message = "titular - El dato ingresado es invalido")
    @Positive(message = "titular - El dato ingresado es invalido")
    private BigDecimal saldo;

    public CrearCuentaDTO() {
    }

    public CrearCuentaDTO(Integer titular, BigDecimal saldo) {
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