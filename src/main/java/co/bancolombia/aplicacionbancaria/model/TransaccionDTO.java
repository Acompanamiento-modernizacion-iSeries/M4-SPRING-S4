package co.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransaccionDTO {

    @NotNull(message ="El ID de la cuenta es Obligatorio")
    private String cuentaID;
    @NotNull(message = "El monto de la transacción es obligatorio! ")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;
    @NotBlank(message ="La descripcion es Obligatoria")
    private String descripcion;

    public String getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(String cuentaID) {
        this.cuentaID = cuentaID;
    }

    public TransaccionDTO(String cuentaID, BigDecimal monto, String descripcion) {
        this.cuentaID = cuentaID;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TransaccionDTO{" +
                "cuentaID='" + cuentaID + '\'' +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
