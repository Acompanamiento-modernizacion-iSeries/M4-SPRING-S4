package co.bancolombia.aplicacionbancaria.model.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransaccionDTO {
    @NotNull(message = "idCuenta - El dato ingresado es invalido")
    @Positive(message = "idCuenta - El dato ingresado es invalido")
    private Long idCuenta;

    @NotNull(message = "monto - El dato ingresado es invalido")
    @Positive(message = "monto - El dato ingresado es invalido")
    private BigDecimal monto;
    private String descripcionTransaccion;

    public TransaccionDTO(Long cuentaId, BigDecimal monto, String descripcionTransaccion) {
        this.idCuenta = cuentaId;
        this.monto = monto;
        this.descripcionTransaccion = descripcionTransaccion;
    }

    public TransaccionDTO() {}

    public Long getCuentaId() {
        return idCuenta;
    }

    public void setCuentaId(Long cuentaId) {
        this.idCuenta = cuentaId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcionTransaccion() {
        return descripcionTransaccion;
    }

    public void setDescripcionTransaccion(String descripcionTransaccion) {
        this.descripcionTransaccion = descripcionTransaccion;
    }
}
