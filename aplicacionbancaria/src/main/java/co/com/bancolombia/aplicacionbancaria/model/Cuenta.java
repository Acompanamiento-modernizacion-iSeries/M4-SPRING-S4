package co.com.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String numero;
    protected String titular;
    protected BigDecimal saldo;

    @OneToMany(mappedBy = "cuenta")
    protected List<Transaccion> transacciones;

    public Cuenta() { }

    public Cuenta(Long id, String numero, String titular, BigDecimal saldo) {
        this.id = id;
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public BigDecimal saldo() {
        return saldo;
    }

    public void actualizarSaldo(BigDecimal nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
}
