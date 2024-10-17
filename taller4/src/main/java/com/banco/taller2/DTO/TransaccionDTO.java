package com.banco.taller2.DTO;

import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

public class TransaccionDTO {
    @NotNull(message = "El ID de la cuenta es obligatorio")
    private String cuentaId;

    @NotNull(message = "El monto de la transaccion es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    @DecimalMax(value = "100000000.00", message = "El monto maximo que se permite es 100,000,000")
    private BigDecimal monto;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 5, max = 100, message = "La descripción debe tener entre 5 y 100 caracteres")
    private String descripcion;

    public TransaccionDTO(String cuentaId, BigDecimal monto, String descripcion) {
        this.cuentaId = cuentaId;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
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
                "monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                ", cuentaId='" + cuentaId + '\'' +
                '}';
    }
}
