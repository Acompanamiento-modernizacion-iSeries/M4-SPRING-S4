package co.bancolombia.aplicacionbanco.model.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class IngresarCuentaDTO {

    @NotNull(message = "Debe ingresar el saldo")
    @Positive(message = "El saldo debe ser mayor a cero")
    private BigDecimal saldo;

    public IngresarCuentaDTO() {
    }

    public IngresarCuentaDTO(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
