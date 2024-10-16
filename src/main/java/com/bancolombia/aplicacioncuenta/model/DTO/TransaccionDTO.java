package com.bancolombia.aplicacioncuenta.model.DTO;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;

import com.bancolombia.aplicacioncuenta.model.Cuenta;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public class TransaccionDTO {

    @Positive(message = "Monto debe ser mayor a cero!!")
    @NotNull(message = "Monto no puede estar vacío!!")
    private BigDecimal monto;

    @NotNull(message = "Descripción obligatoria!!")
    private String descripcion;

    @NotNull(message = "Id obligatorio!!")
    private String cuentaId;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    public TransaccionDTO(BigDecimal monto, String descripcion, String cuentaId) {
        this.monto = monto;
        this.descripcion = descripcion;
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

    public String getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public enum TipoTransaccion {
        DEPOSITO,
        RETIRO
    }
}
