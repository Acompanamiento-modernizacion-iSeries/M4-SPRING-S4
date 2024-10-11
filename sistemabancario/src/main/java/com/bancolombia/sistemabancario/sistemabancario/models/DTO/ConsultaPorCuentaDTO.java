package com.bancolombia.sistemabancario.sistemabancario.models.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConsultaPorCuentaDTO {

    @NotNull(message = "Debe ingresar el id de la cuenta")
    @Positive(message = "El id de la cuenta debe ser mayor a cero")
    private Long idCuenta;

    public ConsultaPorCuentaDTO() {
    }

    public Long getCuentaId() {
        return idCuenta;
    }

    public void setCuentaId(Long cuentaId) {
        this.idCuenta = cuentaId;
    }
}
