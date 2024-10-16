package co.bancolombia.aplicacionbancaria.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BuscarCuentaDTO {

    @NotNull(message = "idCuenta - El número de la cuenta esta vacio")
    @Positive(message = "idCuenta - El dato ingresado es invalido")
    private Long idCuenta;

    public BuscarCuentaDTO() {
    }
    public Long getCuentaId() {
        return idCuenta;
    }

    public void setCuentaId(Long cuentaId) {
        this.idCuenta = cuentaId;
    }
}