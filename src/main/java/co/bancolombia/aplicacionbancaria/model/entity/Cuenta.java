package co.bancolombia.aplicacionbancaria.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "nro_cuenta")
    private String nroCuenta;

    @Column(name = "titular")
    private  String nombreTitular;

    @Column(name = "saldo")
    private BigDecimal monto;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;

    public Cuenta(String nroCuenta, String nombreTitular, BigDecimal monto, List<Transaccion> transacciones) {
        this.nroCuenta = nroCuenta;
        this.nombreTitular = nombreTitular;
        this.monto = monto;
        this.transacciones = transacciones;
    }

    public Cuenta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void deposito(BigDecimal valor) throws Exception {
        if (valor.compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor a 0");
        }
        monto = monto.add(valor);
    }

    public void retiro(BigDecimal valor) throws Exception {
        if (valor.compareTo(BigDecimal.ZERO) <= 0 ) {
            throw new IllegalArgumentException("El monto del retiro debe ser mayor a 0");
        }
        if (monto.compareTo(valor) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        monto = monto.subtract(valor);
    }

    public Transaccion asignarTransaccion(String tipoTransaccion, BigDecimal monto) throws Exception {
        if (!tipoTransaccion.equals("RETIRO") && !tipoTransaccion.equals( "DEPOSITO") ) {
            throw new IllegalArgumentException("Tipo de transacción NO valida");
        }
        Transaccion transaccion = new Transaccion();
        transaccion.setFecha(LocalDateTime.now());
        transaccion.setTipoTrx(tipoTransaccion);
        transaccion.setMonto(monto);
        transaccion.setCuenta(this);
        return transaccion;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", nroCuenta='" + nroCuenta + '\'' +
                ", nombreTitular='" + nombreTitular + '\'' +
                ", monto=" + monto +
                ", " + transacciones.toString() +
                '}';
    }
}