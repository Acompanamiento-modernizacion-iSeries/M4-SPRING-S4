package co.bancolombia.aplicacionbancaria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaBanco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nro_cuenta")
    private String nroCuenta;
    private String titular;
    private BigDecimal saldo;
    @OneToMany(mappedBy = "cuentaAsociada")
    private List<Transaccion> transacciones;

}
