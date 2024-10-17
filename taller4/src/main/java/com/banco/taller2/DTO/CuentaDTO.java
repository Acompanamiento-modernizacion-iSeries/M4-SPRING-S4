package com.banco.taller2.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class CuentaDTO {
    @NotNull(message = "El id de la cuenta es obligatorio")
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
