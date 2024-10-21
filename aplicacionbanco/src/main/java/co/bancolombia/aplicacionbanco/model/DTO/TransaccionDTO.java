package co.bancolombia.aplicacionbanco.model.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransaccionDTO {

    @NotNull(message = "Debe ingresar el id de la  cuenta")
    @Positive(message = "El id cuenta debe ser mayor a cero")
    private Long cuentaId;

    @NotNull(message = "Debe ingresar el valor de la transacción")
    @Positive(message = "El valor debe ser mayor a cero")
    private BigDecimal monto;
    private String descripcionTransaccion;

    public TransaccionDTO() {
    }

    public TransaccionDTO(Long cuentaId, BigDecimal monto, String descripcionTransaccion) {
        this.cuentaId = cuentaId;
        this.monto = monto;
        this.descripcionTransaccion = descripcionTransaccion;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
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
