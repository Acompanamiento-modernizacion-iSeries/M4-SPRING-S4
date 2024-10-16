package co.com.bancolombia.aplicacionbancaria.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class CuentaDTO {

    @NotEmpty(message = "Debe ingresar un ID de cuenta")
    @Min(message = "Debe ingresar un ID de cuenta válido", value = 1L)
    protected String id;

    protected String descripcion;

    public CuentaDTO(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion == null ? "Consulta Informacion de Cuenta" : descripcion;
    }

    public Long id() {
        return Long.valueOf(id);
    }
}
