package com.bancolombia.aplicacionbancaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre del cliente es requerido")
    private String nombreCliente;

    @NotNull(message = "El saldo de la cuenta es requerido")
    private BigDecimal saldo;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransaccionDTO> transacciones = new ArrayList<>();


    public Cuenta(String nombreCliente, BigDecimal saldo, List<TransaccionDTO> transacciones) {
        this.nombreCliente = nombreCliente;
        this.saldo = saldo;
        this.transacciones = transacciones;
    }

    public boolean retirar(BigDecimal cantidad) {
        if (this.saldo.compareTo(cantidad) >= 0) {
            this.saldo = this.saldo.subtract(cantidad);
            return true;
        }
        return false;
    }


    public void agregarTransaccion(TransaccionDTO transaccion) {
        this.transacciones.add(transaccion);
        transaccion.setCuenta(this);
    }

    public Cuenta() {
    }

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

    public List<TransaccionDTO> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<TransaccionDTO> transacciones) {
        this.transacciones = transacciones;
    }
}
