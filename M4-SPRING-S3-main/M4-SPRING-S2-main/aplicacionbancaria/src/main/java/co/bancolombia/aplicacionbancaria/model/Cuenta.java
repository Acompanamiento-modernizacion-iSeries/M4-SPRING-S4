package co.bancolombia.aplicacionbancaria.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String numeroCuenta;
    private String nombre;

    private BigDecimal saldo;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaccion> transaccionList;

    public Cuenta(){}

    public Cuenta(String nombre) {
        this.nombre = nombre;
        this.saldo = BigDecimal.ZERO;
    }

    public Cuenta(Long id, String numeroCuenta, String nombre, BigDecimal saldo, List<Transaccion> transaccionList) {
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
        this.transaccionList = transaccionList;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }



    public String getNombre() {
        return nombre;
    }

    public void depositar(BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
    }

    public boolean retirar(BigDecimal monto) {
        if (this.saldo.compareTo(monto) >= 0) {
            this.saldo = this.saldo.subtract(monto);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", saldo=" + saldo +
                ", transaccionList=" + transaccionList +
                '}';
    }
}
