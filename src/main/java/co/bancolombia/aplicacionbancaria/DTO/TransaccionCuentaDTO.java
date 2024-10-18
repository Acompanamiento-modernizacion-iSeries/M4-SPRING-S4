package co.bancolombia.aplicacionbancaria.DTO;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TransaccionCuentaDTO {

    @NotEmpty(message ="El ID de la cuenta es Obligatorio")
    @Pattern(regexp = "\\d+", message = "El ID de la cuenta debe contener solo números")
    @Size(min = 4, message = "El ID de la cuenta debe tener al menos 4 caracteres")
    @Size(max = 10, message = "El ID de la cuenta debe tener como maximo 10 caracteres")
    private String cuentaID;
    private String id;


    public String getCuentaID() {
        return cuentaID;
    }
    public void setCuentaID(String cuentaID) {
        this.cuentaID = cuentaID;
    }

    public TransaccionCuentaDTO() {}
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
