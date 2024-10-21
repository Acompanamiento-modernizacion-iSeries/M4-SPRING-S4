package co.com.bancolombia.aplicacionbancaria.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Cuenta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal saldo;

    public Cuenta() {
    }

    public Cuenta(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal obtenerSaldo() {
        return saldo;
    };

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    };

    public BigDecimal getSaldo() {
        return saldo;
    };

    public Long getNumeroCuenta() {
        return id;
    };

    public void retiro(BigDecimal monto){
        BigDecimal saldo = obtenerSaldo();
        saldo = saldo.subtract(monto);
        setSaldo(saldo);
    };


    public void deposito(BigDecimal monto) {
        BigDecimal saldo = obtenerSaldo();
        saldo = saldo.add(monto);
        setSaldo(saldo);
    }
}