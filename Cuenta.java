package co.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuenta_bancaria")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_nro")
    private Long nroCuenta;

    private BigDecimal saldo;
    private String titular;

    @Column(name = "id_Titular")
    private String documentoTitular;



    @OneToMany(mappedBy = "cuenta_Asociada")
    private List<Transaccion> transacciones;

    public Cuenta(BigDecimal saldo, String titular, String documentoTitular) {
        this.saldo = saldo;
        this.titular = titular;
        this.documentoTitular = documentoTitular;
 
    }

    public Cuenta() {
    }

    public Long consultarCuenta() {

        return nroCuenta;
    }

    public void asignarCuenta(Long nroCuenta) {

        this.nroCuenta = nroCuenta;
    }

    public BigDecimal consultarSaldo() {

        return saldo;
    }

    public void asignarSaldo(BigDecimal saldo) {

        this.saldo = saldo;
    }

    public String consultarTitular() {

        return titular;
    }

    public void asignarTitular(String titular) {

        this.titular = titular;
    }

    public String consultarDocumentoTitular() {

        return documentoTitular;
    }

    public void asignarDocumentoTitular(String documentoTitular) {

        this.documentoTitular = documentoTitular;
    }

    public String consultarTelefono() {

        return telefono;
    }

    public List<Transaccion> consultarTransacciones() {
        return transacciones;
    }

    public void asignarTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void deposito(BigDecimal monto) {
        saldo = saldo.add(monto);
    }

    public void retiro(BigDecimal monto) {
        saldo = saldo.subtract(monto);
    }

    @Override
    public String toString() {
        return "{" + '\n' +
                "Titular= " + titular + '\n' +
                "Cuenta= " + nroCuenta + '\n' +
                "Saldo= " + saldo + '\n' +
                '}';
    }
}
