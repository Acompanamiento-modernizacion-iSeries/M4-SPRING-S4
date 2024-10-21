package co.com.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;

@Entity
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaccion;
    private Integer idCuenta;
    private String tipoTransaccion;
    private String descripcion;


    public Transaccion() {
    }

    public Transaccion(Integer idCuenta, String tipoTransaccion, String descripcion) {
        this.idCuenta = idCuenta;
        this.tipoTransaccion = tipoTransaccion;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return idTransaccion;
    }

    public void setId(Long id) {
        this.idTransaccion = idTransaccion;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}