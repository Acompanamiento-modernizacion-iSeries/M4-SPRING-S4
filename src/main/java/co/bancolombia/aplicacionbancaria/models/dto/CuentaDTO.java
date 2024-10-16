package co.bancolombia.aplicacionbancaria.models.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public class CuentaDTO {

    @NotNull(message = "idCuenta - El dato ingresado es invalido")
    private Long idCuenta;

    public CuentaDTO() {}

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }
}
