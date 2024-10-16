package com.bancolombia.aplicacionbanco.DTO;

import jakarta.validation.constraints.NotNull;

public class CuentaDTO {

    @NotNull(message = "El ID de la cuenta es obligatorio!")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CuentaDTO{" +
                "id=" + id +
                '}';
    }
}
