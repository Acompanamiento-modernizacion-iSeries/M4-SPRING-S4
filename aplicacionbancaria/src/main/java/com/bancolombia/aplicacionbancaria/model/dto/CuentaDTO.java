package com.bancolombia.aplicacionbancaria.model.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;


@Validated
public class CuentaDTO {

    @NotNull(message = "Debe ingresar una cuenta valida")
    private Long cuenta;

    public CuentaDTO(Long cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaDTO() {
    }

    public Long getCuenta() {
        return cuenta;
    }

}
