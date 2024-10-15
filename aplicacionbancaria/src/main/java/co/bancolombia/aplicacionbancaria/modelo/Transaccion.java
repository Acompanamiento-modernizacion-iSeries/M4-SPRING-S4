package co.bancolombia.aplicacionbancaria.modelo;

import jakarta.persistence.*;
import lombok.Builder;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "transacciones")
@Builder
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cuenta_asociada")
    private CuentaBanco cuentaAsociada;

    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;

    private BigDecimal valor;

    @Column(name = "fecha")
    private Timestamp timestamp;
}
