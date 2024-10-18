package co.bancolombia.aplicacionbancaria.model.dto;

import jakarta.validation.constraints.NotEmpty;

public class NumeroCuentaDTO {
    @NotEmpty(message ="El ID de la cuenta es Obligatorio")
    private String nroCuenta;

    public NumeroCuentaDTO(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    public NumeroCuentaDTO() {}

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    @Override
    public String toString() {
        return "NumeroCuentaDTO{" +
                "nroCuenta=" + nroCuenta +
                '}';
    }
}
