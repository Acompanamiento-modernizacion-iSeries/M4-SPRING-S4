package co.bancolombia.aplicacionbanco.model.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BuscarCuentaDTO {

    @NotNull(message = "Debe ingresar el id de la cuenta")
    @Positive(message = "El id de la cuenta debe ser mayor a cero")
    private Long cuentaId;

    public BuscarCuentaDTO() {
    }

    public BuscarCuentaDTO(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }
}
