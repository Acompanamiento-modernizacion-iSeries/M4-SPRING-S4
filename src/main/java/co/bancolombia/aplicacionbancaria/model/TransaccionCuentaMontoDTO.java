package co.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TransaccionCuentaMontoDTO {

    @NotNull(message ="El ID de la cuenta es Obligatorio")
    @Pattern(regexp = "\\d+", message = "El ID de la cuenta debe contener solo números")
    @Size(min = 4, message = "El ID de la cuenta debe tener al menos 4 caracteres")
    private String cuentaID;

    @NotNull(message = "El monto de la transacción es obligatorio! ")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;

    public String getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(String cuentaID) {
        this.cuentaID = cuentaID;
    }

    public TransaccionCuentaMontoDTO(String cuentaID, BigDecimal monto) {
        this.cuentaID = cuentaID;
        this.monto = monto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "TransaccionCuentaMontoDTO{" +
                "cuentaID='" + cuentaID + '\'' +
                ", monto=" + monto +
                '}';
    }
}
