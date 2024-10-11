package co.bancolombia.aplicacionbancaria.model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TransaccionCuentaDTO {

    @NotNull(message ="El ID de la cuenta es Obligatorio")
    @Pattern(regexp = "\\d+", message = "El ID de la cuenta debe contener solo números")
    @Size(min = 4, message = "El ID de la cuenta debe tener al menos 4 caracteres")
    private String cuentaID;

    public String getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(String cuentaID) {
        this.cuentaID = cuentaID;
    }

    public TransaccionCuentaDTO(String cuentaID, BigDecimal monto) {
        this.cuentaID = cuentaID;
    }

    @Override
    public String toString() {
        return "TransaccionCuentaDTO{" +
                "cuentaID='" + cuentaID + '\'' +
                '}';
    }
}
