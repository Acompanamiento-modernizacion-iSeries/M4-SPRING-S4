package co.com.coban.aplicacionbancaria.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransaccionDTO {
    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a cero")
    @Digits(integer = 10, fraction = 2, message = "El monto debe tener máximo 10 enteros y 2 decimales")
    private BigDecimal monto;
    private String descripcion;
    @NotNull(message = "El id de la cuenta es obligatorio")
    @NotEmpty(message = "El id de la cuenta no puede estar vacío")
    @Positive(message = "El id de la cuenta debe ser mayor a cero")
    private String idCuenta;

    public TransaccionDTO() {
    }

    public TransaccionDTO(BigDecimal monto, String descripcion) {
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

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public String toString() {
        return "TransaccionDTO{" +
                "monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
