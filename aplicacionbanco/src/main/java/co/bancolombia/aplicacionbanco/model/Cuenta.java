package co.bancolombia.aplicacionbanco.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Table(name="cuenta_bancaria")
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cuenta_id")
    private Long cuentaId;
    private BigDecimal saldo;
    @OneToMany(mappedBy = "cuenta")
    private List<Transaccion> transacciones;
    public Cuenta(){
            transacciones = new ArrayList<>();
    }

    public Cuenta(Long cuentaId, BigDecimal saldo) {
        this.cuentaId = cuentaId;
        this.saldo = saldo;
    }

    public Long getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Long cuentaId) {
        this.cuentaId = cuentaId;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public String toString() {
        return "id de Cuenta :" + cuentaId +
                "\n" +
                "saldo actual: " + saldo ;
    }
}

