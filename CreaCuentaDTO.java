package co.bancolombia.aplicacionbancaria.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreaCuentaDTO {
    @NotNull(message = "El saldo debe infromarce")
    @Positive(message = "El saldo debe ser mayor a cero")
    private BigDecimal saldo;

    @NotEmpty(message = "El titular es obligatorio")
    private String titular;

    @NotEmpty(message = "El documento del titular es obligatorio!")
    private String documentoTitular;



    public CreaCuentaDTO(BigDecimal saldo, String titular, String documentoTitular) {
        this.saldo = saldo;
        this.titular = titular;
        this.documentoTitular = documentoTitular;
    
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

}
