package co.com.coban.aplicacionbancaria.controller;

import co.com.coban.aplicacionbancaria.service.CuentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("{id}/saldo")
    public String saldo(@PathVariable("id") String id) {
        return cuentaService.obtenerSaldo(id);
    }

    @PostMapping("/{id}/deposito/{monto}")
    public String deposito(@PathVariable("id") String id, @PathVariable BigDecimal monto) {
        return cuentaService.deposito(id, monto);
    }

    @PostMapping("/{id}/retiro/{monto}")
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
    public String retiro(@PathVariable("id") String id, @PathVariable BigDecimal monto) {
        return cuentaService.retiro(id, monto);
    }
}
