package co.bancolombia.aplicacionbancaria.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class DepositoRetiroDTO {

    @NotEmpty(message ="El número de cuenta es Obligatorio")
    @Size(max = 10, message = "El número de cuenta debe tener un máximo de 10 caracteres!")
    @Size(min = 4, message = "El número de cuenta debe tener un minimo de 4 caracteres!")
    @Pattern(regexp="^\\d+$", message = "El número de cuenta debe ser un valor numérico")
    private String nroCuenta;

    @NotNull(message = "El monto es obligatorio!")
    @Positive(message = "El monto debe ser mayor a cero!")
    private BigDecimal monto;

    public DepositoRetiroDTO(String nroCuenta, BigDecimal monto) {
        this.nroCuenta = nroCuenta;
        this.monto = monto;
    }
    public DepositoRetiroDTO() { }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}

