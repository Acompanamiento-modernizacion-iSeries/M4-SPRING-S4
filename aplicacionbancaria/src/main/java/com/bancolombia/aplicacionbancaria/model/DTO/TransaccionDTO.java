package com.bancolombia.aplicacionbancaria.model.DTO;

import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

//Estructura que se pretende recibir desde el cliente
@Validated
public class TransaccionDTO {
    //private final CuentaDb cuentaDb;
    @NotNull(message = "El numero de cuenta es obligatorio")
    private Long cuenta;

    @NotBlank(message = "EL tipo de transaccion es obligatorio")
    @Pattern(regexp = "retiro|depósito", message = "El tipo de transacción debe ser 'retiro' o 'depósito'")
    private String tipoTransaccion;
    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "Solo se permiten valores positivos")
    private BigDecimal monto;


    public TransaccionDTO(){

    }
    public TransaccionDTO(Long cuenta, String tipoTransaccion, BigDecimal monto) {
        this.cuenta = cuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
    }

    public Long getCuenta() {
        return cuenta;
    }

    public void setCuenta(Long cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "TransaccionDTO{" +
                "cuenta=" + cuenta +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", monto=" + monto +
                '}';
    }
}
