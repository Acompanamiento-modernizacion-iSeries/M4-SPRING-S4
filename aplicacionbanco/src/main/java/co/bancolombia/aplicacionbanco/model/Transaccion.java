package co.bancolombia.aplicacionbanco.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.sql.Timestamp;


import java.math.BigDecimal;
@Table(name="historial_transacciones")
@Entity

public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaccion_id")
    private Long transaccionid;
    @Column(name = "tipo_transaccion")
    private String tipotransaccion;
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "fecha_transaccion")
    private Timestamp fechatransaccion;

    @ManyToOne
    @JoinColumn(name = "cuentaId")
    private Cuenta cuenta;

    public Transaccion() {

    }

    public Transaccion(Long transaccionid, String tipotransaccion, BigDecimal monto, Timestamp fechatransaccion, Cuenta cuenta) {
        this.transaccionid = transaccionid;
        this.tipotransaccion = tipotransaccion;
        this.monto = monto;
        this.fechatransaccion = fechatransaccion;
        this.cuenta = cuenta;
    }

    public Long getTransaccionid() {
        return transaccionid;
    }

    public void setTransaccionid(Long transaccionid) {
        this.transaccionid = transaccionid;
    }

    public String getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(String tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Timestamp getFechatransaccion() {
        return fechatransaccion;
    }

    public void setFechatransaccion(Timestamp fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}

