package co.bancolombia.aplicacionbancaria.model.dto;


import co.bancolombia.aplicacionbancaria.model.entity.Cuenta;
import co.bancolombia.aplicacionbancaria.model.entity.Transaccion;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CrearCuentaDTO {

    @NotEmpty(message ="El número de cuenta es Obligatorio")
    @Size(max = 10, message = "El número de cuenta debe tener un máximo de 10 caracteres!")
    @Size(min = 4, message = "El número de cuenta debe tener un minimo de 4 caracteres!")
    @Pattern(regexp="^\\d+$", message = "El número de cuenta debe ser un valor numérico")
    private String nroCuenta;// nro_cuenta Varchar(10)   NOT NULL,

    @NotEmpty(message ="El titular es Obligatorio")
    @Size(max = 255, message = "El titular debe tener un máximo de 255 caracteres!")
    @Size(min = 5, message = "El titular debe tener un minimo de 5 caracteres!")
    private String titular;

    @NotNull(message = "El monto es obligatorio!")
    @Positive(message = "El monto debe ser mayor a cero!")
    private BigDecimal monto;

   public CrearCuentaDTO() {
    }

    public CrearCuentaDTO(String nroCuenta, String titular, BigDecimal monto) {
        this.nroCuenta = nroCuenta;
        this.titular = titular;
        this.monto = monto;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    /*public Transaccion llenarTransaccion(Cuenta datosCuenta , String tipo_transaccion, BigDecimal monto){
        Transaccion historia = new Transaccion(null,
                tipo_transaccion,
                monto,
                Timestamp.valueOf(currentTS),
                datosCuenta);
        return historia;
    }*/
}