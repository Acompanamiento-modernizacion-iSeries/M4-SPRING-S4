package com.bancolombia.aplicacionbancaria.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transacciones")
public class TransaccionDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @NotNull(message = "El monto de la transaccion es obligatoria")
    @Positive(message = "EL monto debe ser mayor a cero!")
    @Min(message = "El monto minimo a depositor/Retirar debe ser de 10.000", value = 10000L)
    @Max(message = "El monto maximo aceptable a depositor/Retirar debe ser hasta 1.000.000", value = 1000000L)
    private BigDecimal monto;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;



 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTipo() {
  return tipo;
 }

 public void setTipo(String tipo) {
  this.tipo = tipo;
 }

 public BigDecimal getMonto() {
  return monto;
 }

 public void setMonto(BigDecimal monto) {
  this.monto = monto;
 }

 public LocalDateTime getFecha() {
  return fecha;
 }

 public void setFecha(LocalDateTime fecha) {
  this.fecha = fecha;
 }

 public Cuenta getCuenta() {
  return cuenta;
 }

 public void setCuenta(Cuenta cuenta) {
  this.cuenta = cuenta;
 }
}
