package co.com.coban.aplicacionbancaria.dto;

import jakarta.validation.constraints.NotBlank;

public class CuentaDTO {
    @NotBlank(message = "El id de la cuenta no puede ser vacío.")
    private String id;

    public String getId() {
        return id;
    }
}
