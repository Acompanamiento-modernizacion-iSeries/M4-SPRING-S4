package co.com.coban.aplicacionbancaria.controller;

import co.com.coban.aplicacionbancaria.dto.CuentaDTO;
import co.com.coban.aplicacionbancaria.dto.TransaccionDTO;
import co.com.coban.aplicacionbancaria.service.CuentaService;
import co.com.coban.aplicacionbancaria.service.CuentaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    // Swagger spring doc http://localhost:8080/swagger-ui/index.html

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{id}")
    public String validarCuenta(@PathVariable Long id) {
        return cuentaService.validarCuenta(id) ? "Cuenta válida" : "Cuenta inválida";
    }

    @GetMapping("/saldo")
    public String saldo(@RequestBody CuentaDTO cuenta) {
        BigDecimal saldo = cuentaService.obtenerSaldo(cuenta.getId());
        return "El saldo de la cuenta es: " + saldo;
    }

    @PostMapping("/{id}/deposito/{monto}")
    public String deposito2(@PathVariable("id") Long id, @PathVariable BigDecimal monto) {
        return cuentaService.deposito(id, monto);
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccion, @Valid @RequestBody CuentaDTO cuenta) {
        return cuentaService.deposito(cuenta.getId(), transaccion.getMonto());
    }

    @PostMapping("/retiro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retiro exitoso"),
            @ApiResponse(responseCode = "400", description = "Error en el retiro")
    })
    @Operation(
            summary = "Retirar dinero de la cuenta",
            description = "Retirar dinero de la cuenta",
            tags = {"cuenta"},
            parameters = {
                    @io.swagger.v3.oas.annotations.Parameter(
                            name = "id",
                            description = "Identificador de la cuenta",
                            required = true,
                            example = "1",
                            schema = @io.swagger.v3.oas.annotations.media.Schema(type = "string")
                    ),
                    @io.swagger.v3.oas.annotations.Parameter(
                            name = "monto",
                            description = "Monto a retirar",
                            required = true,
                            example = "1000.00",
                            schema = @io.swagger.v3.oas.annotations.media.Schema(type = "number")
                    )
            }
    )
    public String retiro(@Valid @RequestBody TransaccionDTO transaccion, @Valid @RequestBody CuentaDTO cuenta) {
        return cuentaService.retiro(cuenta.getId(), transaccion.getMonto());
    }
}
