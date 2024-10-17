package com.bancolombia.aplicacionbancaria.model.DTO;


import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class ConsultaDTO {
    @NotNull(message = "El numero de cuenta es obligatorio")
    private Long cuenta_id;

    public ConsultaDTO(Long cuenta_id) {
        this.cuenta_id = cuenta_id;
    }
    public ConsultaDTO() {
    }

    public Long getCuenta_id() {
        return cuenta_id;
    }

    public void setCuenta_id(Long cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    @Override
    public String toString() {
        return "ConsultaDTO{" +
                "cuenta_id=" + cuenta_id +
                '}';
    }
}
