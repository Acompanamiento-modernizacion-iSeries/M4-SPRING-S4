package co.bancolombia.aplicacionbancaria.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta")
    private Long idCuenta;
    private Integer titular;
    private BigDecimal saldo;
    @OneToMany(mappedBy = "cuenta")
    private List<Transaccion> transacciones ;
    public Cuenta() {
        transacciones = new ArrayList<>();
    }
    public Cuenta(Long idCuenta, Integer titular, BigDecimal saldo) {
        this();
        this.idCuenta = idCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }
    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getTitular() {
        return titular;
    }

    public void setTitular(Integer titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public String toString() {
        return "Cuenta :" + idCuenta + "\nSaldo  : " + saldo ;
    }
}