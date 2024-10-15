package com.bancolombia.cuentabancaria.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentabancaria")
public class CuentaBancariaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cuenta;

    private BigDecimal saldo;

    @OneToMany(mappedBy = "cuentabancaria")
    private List<TransaccionEntity> transacciones;

    public CuentaBancariaEntity() {
    }

    public CuentaBancariaEntity(Long id, String cuenta, BigDecimal saldo, List<TransaccionEntity> transacciones) {
        this.id = id;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.transacciones = transacciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<TransaccionEntity> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<TransaccionEntity> transacciones) {
        this.transacciones = transacciones;
    }

    public void deposito(BigDecimal valor){
        saldo = saldo.add(valor);
    }

    public void retiro(BigDecimal valor){
        saldo = saldo.subtract(valor);
    }
}
