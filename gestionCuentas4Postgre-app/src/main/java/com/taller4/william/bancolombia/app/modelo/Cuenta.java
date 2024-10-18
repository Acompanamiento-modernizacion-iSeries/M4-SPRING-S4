package com.taller4.william.bancolombia.app.modelo;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;
    private BigDecimal saldo;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;

    // Métodos para agregar transacción
    public void agregarTransaccion(Transaccion transaccion) {
        this.transacciones.add(transaccion);
        transaccion.setCuenta(this);
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
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
}
