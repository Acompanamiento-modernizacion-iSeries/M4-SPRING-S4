package com.bancolombia.aplicacionbanco.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal saldo;
    private String titular;

    @OneToMany(mappedBy = "idCuenta")
    private List<Transaccion> transaccion;

    public Cuenta(){}

    public Cuenta(BigDecimal saldo, String titular){
        this.saldo=saldo;
        this.titular=titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
