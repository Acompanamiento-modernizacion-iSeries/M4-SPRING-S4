package co.bancolombia.aplicacionbancaria.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreaCuentaDTO {
    @NotNull(message = "El saldo es obligatorio!")
    @Positive(message = "El saldo debe ser mayor a cero!")
    private BigDecimal saldo;

    @NotEmpty(message = "El titular es obligatorio!")
    private String titular;

    @NotEmpty(message = "El documento del titular es obligatorio!")
    private String documentoTitular;

    @NotEmpty(message = "El teléfono es obligatorio!")
    private String telefono;

    @NotEmpty(message = "La dirección es obligatoria!")
    private String direccion;

    @NotEmpty(message = "El email es obligatorio!")
    private String email;

    public CreaCuentaDTO(BigDecimal saldo, String titular, String documentoTitular, String telefono, String direccion, String email) {
        this.saldo = saldo;
        this.titular = titular;
        this.documentoTitular = documentoTitular;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
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

    public void asignarTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String consultarDireccion() {
        return direccion;
    }

    public void asignarDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String consultarEmail() {
        return email;
    }

    public void asignarEmail(String email) {
        this.email = email;
    }
}
