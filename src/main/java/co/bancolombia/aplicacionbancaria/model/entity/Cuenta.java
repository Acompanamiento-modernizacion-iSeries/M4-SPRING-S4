package co.bancolombia.aplicacionbancaria.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "nro_cuenta")
    private String nroCuenta;

    @Column(name = "titular")
    private  String nombreTitular;

    @Column(name = "saldo")
    private BigDecimal monto;

    @OneToMany(mappedBy = "cuenta")
    private List<Transaccion> transacciones;

    public Cuenta(String nroCuenta, String nombreTitular, BigDecimal monto, List<Transaccion> transacciones) {
        this.nroCuenta = nroCuenta;
        this.nombreTitular = nombreTitular;
        this.monto = monto;
        this.transacciones = transacciones;
    }

    public Cuenta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void deposito(BigDecimal valor) {
        monto = monto.add(valor);
    }

    public void retiro(BigDecimal valor) {
        monto = monto.subtract(valor);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", nroCuenta='" + nroCuenta + '\'' +
                ", nombreTitular='" + nombreTitular + '\'' +
                ", monto=" + monto +
                ", " + transacciones.toString() +
                '}';
    }
}