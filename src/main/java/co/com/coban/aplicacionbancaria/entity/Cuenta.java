package co.com.coban.aplicacionbancaria.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuenta_id")
    private Long id;
    private String nombreUsuario;
    private String tipo;
    private BigDecimal saldo;

    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private Set<Transaccion> historialTransacciones = new HashSet<>();

    public Cuenta() {
    }

    public Cuenta(String nombre, String tipo, BigDecimal saldo) {
        this.nombreUsuario = nombre;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombre) {
        this.nombreUsuario = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
