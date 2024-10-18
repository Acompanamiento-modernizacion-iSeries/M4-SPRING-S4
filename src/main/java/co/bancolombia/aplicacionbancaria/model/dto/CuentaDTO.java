package co.bancolombia.aplicacionbancaria.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CuentaDTO {
    @NotNull(message ="El ID de la cuenta es Obligatorio")
    @Positive(message = "El ID de la cuenta debe ser mayor a cero!")
    private Long id;

    public CuentaDTO(Long id) {
        this.id = id;
    }
    public CuentaDTO() {}

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
