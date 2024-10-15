package co.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;

    @ManyToOne
    @JoinColumn(name = "cuenta_asociada")
    private Cuenta cuentaAsociada;

    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;

    private BigDecimal valor;

    private LocalDate fecha;

    private LocalTime hora;

    public Transaccion(Cuenta cuentaAsociada, String tipoTransaccion, BigDecimal valor, LocalDate fecha, LocalTime hora) {
        this.cuentaAsociada = cuentaAsociada;
        this.tipoTransaccion = tipoTransaccion;
        this.valor = valor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Transaccion() {
    }

    public Long consultarTransaccion() {
        return idTransaccion;
    }

    public void asignarTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Cuenta consultarCuentaAsociada() {
        return cuentaAsociada;
    }

    public void asignarCuentaAsociada(Cuenta cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    public String consultarTipoTransaccion() {
        return tipoTransaccion;
    }

    public void asignarTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal consultarValor() {
        return valor;
    }

    public void asignarValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate consultarFecha() {
        return fecha;
    }

    public void asignarFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime consultarHora() {
        return hora;
    }

    public void asignarHora(LocalTime hora) {
        this.hora = hora;
    }
}