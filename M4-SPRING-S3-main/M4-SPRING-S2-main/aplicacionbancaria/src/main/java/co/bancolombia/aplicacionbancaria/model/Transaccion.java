package co.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal retiro;
    private BigDecimal deposito;
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "numeroCuenta")
    private Cuenta cuenta;

    public Transaccion(){}

    public Transaccion(Long id, BigDecimal retiro, BigDecimal deposito, String fecha, Cuenta cuenta) {
        this.id = id;
        this.retiro = retiro;
        this.deposito = deposito;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    public Transaccion(BigDecimal retiro, BigDecimal deposito, String fecha, Cuenta cuenta) {
        this.retiro = retiro;
        this.deposito = deposito;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    public BigDecimal getRetiro() {
        return retiro;
    }

    public void setRetiro(BigDecimal retiro) {
        this.retiro = retiro;
    }

    public BigDecimal getDeposito() {
        return deposito;
    }

    public void setDeposito(BigDecimal deposito) {
        this.deposito = deposito;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
