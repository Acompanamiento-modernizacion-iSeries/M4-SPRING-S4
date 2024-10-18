package co.bancolombia.aplicacionbancaria.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConsultarCuentaDTO {
    @NotNull(message ="El ID de la cuenta es Obligatorio")
    @Positive(message = "El ID de la cuenta debe ser mayor a cero!")
    private Long id;

    public ConsultarCuentaDTO(Long id) {
        this.id = id;
    }
    public ConsultarCuentaDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
