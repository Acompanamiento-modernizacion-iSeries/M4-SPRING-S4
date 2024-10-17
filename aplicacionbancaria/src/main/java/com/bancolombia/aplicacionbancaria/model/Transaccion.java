package com.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaccionId;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuentaId1;
    private String tipoTransaccion;
    private BigDecimal monto;
    private String descripcion;

    public Transaccion(Long transaccionId, Cuenta cuentaId1, String tipoTransaccion, BigDecimal monto, String descripcion) {
        this.transaccionId = transaccionId;
        this.cuentaId1 = cuentaId1;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.descripcion = descripcion;
    }
    public Transaccion(){

    }

    public Long getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Long transaccionId) {
        this.transaccionId = transaccionId;
    }

    public Cuenta getCuentaId1() {
        return cuentaId1;
    }

    public void setCuentaId1(Cuenta cuentaId1) {
        this.cuentaId1 = cuentaId1;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "transaccionId=" + transaccionId +
                ", cuentaId=" + cuentaId1 +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
