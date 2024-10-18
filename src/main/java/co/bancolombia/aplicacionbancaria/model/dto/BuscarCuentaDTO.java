package co.bancolombia.aplicacionbancaria.model.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BuscarCuentaDTO {

    @NotNull(message = "El número de la cuenta esta vacio")
    @Positive(message = "El dato ingresado es invalido")
    private Long idCuenta;

    public BuscarCuentaDTO() {
    }
    public Long getCuentaId() {
        return idCuenta;
    }

    public void setCuentaId(Long idCuenta) {
        this.idCuenta = idCuenta;
    }
}
