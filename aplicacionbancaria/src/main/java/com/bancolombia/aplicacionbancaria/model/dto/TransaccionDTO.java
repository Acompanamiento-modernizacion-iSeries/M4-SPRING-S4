package com.bancolombia.aplicacionbancaria.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Validated
public class TransaccionDTO {

    @NotNull(message = "Debe ingresar una cuenta valida")
    private Long cuenta;

    @NotNull(message = "Debe ingresar un tipo de transacción valido")
    @NotEmpty(message = "Debe ingresar un tipo de transacción valido")
    private String tipoTransaccion;

    @NotNull(message = "Ingrese un monto valido")
    @Positive(message = "Ingrese un monto mayor a cero")
    private BigDecimal monto;

    private Timestamp fechaTransaccion;

    public TransaccionDTO(BigDecimal monto, String tipoTransaccion, Long cuenta, Timestamp fechaTransaccion) {
        this.cuenta =  cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.fechaTransaccion = fechaTransaccion;

    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return tipoTransaccion;
    }

    public Long getCuenta() {
        return cuenta;
    }

    public Timestamp getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Timestamp fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setCuenta(Long cuenta) {
        this.cuenta = cuenta;
    }

}
