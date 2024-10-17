package com.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;
    private String clienteId;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldo;

    @OneToMany(mappedBy = "cuentaId1")
    private List<Transaccion> transaccion;

    public Cuenta(Long cuentaId, String clienteId, String numeroCuenta, String tipoCuenta, BigDecimal saldo) {
        this.cuentaId = cuentaId;
        this.clienteId = clienteId;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
    }

    public Cuenta(){

    }

    public Long getCuenta() {
        return cuentaId;
    }

    public void setCuenta(Long cuenta) {
        this.cuentaId = cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Transaccion> getTransaccion() {
        return transaccion;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cuentaId=" + cuentaId +
                ", clienteId='" + clienteId + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

}
