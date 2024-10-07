package co.com.coban.aplicacionbancaria.controller;

import co.com.coban.aplicacionbancaria.repository.DbCuenta;
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

//    @PostMapping("/deposito/{monto}")
//    @ApiResponses(value = {
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Depósito exitoso"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Error en el depósito")
//    })
//    public String deposito(@PathVariable BigDecimal monto) {
//        if (monto.compareTo(BigDecimal.ZERO) > 0) {
//            if (dbCuenta.obtenerCuenta("1") == null) {
//                return "La cuenta no existe.";
//            }
//            dbCuenta.obtenerCuenta("1").setSaldo(dbCuenta.obtenerCuenta("1").getSaldo().add(monto));
//            return "Depósito exitoso. Saldo actual: " + dbCuenta.obtenerCuenta("1").getSaldo();
//        } else {
//            return "El monto a depositar debe ser mayor a cero.";
//        }
//    }

//    @PostMapping("/deposito2/{monto}")
//    @ApiResponse(responseCode = "200", description = "Depósito exitoso")
//    public String deposito2(@PathVariable("monto") BigDecimal valor) {
//        if (valor.compareTo(BigDecimal.ZERO) > 0) {
//            saldo = saldo.add(valor);
//            return "Depósito exitoso. Saldo actual: " + saldo;
//        } else {
//            return "El monto a depositar debe ser mayor a cero.";
//        }
//    }
//
//    // el mismo metodo anterior pero usando un query param
//    @PostMapping("/deposito3")
//    @ApiResponses (value = {
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Depósito exitoso"),
//            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Error en el depósito")
//    })
//    @Operation(
//            summary = "Depositar dinero en la cuenta",
//            description = "Depositar dinero en la cuenta",
//            tags = {"cuenta"},
//            parameters = {
//                    @io.swagger.v3.oas.annotations.Parameter(
//                            name = "monto",
//                            description = "Monto a depositar",
//                            required = true,
//                            example = "1000.00",
//                            schema = @io.swagger.v3.oas.annotations.media.Schema(type = "number")
//                    )
//            }
//    )
//    public String depositoQueryParam(@RequestParam("monto") BigDecimal valor) {
//        if (valor.compareTo(BigDecimal.ZERO) > 0) {
//            saldo = saldo.add(valor);
//            return "Depósito exitoso. Saldo actual: " + saldo;
//        } else {
//            return "El monto a depositar debe ser mayor a cero.";
//        }
//    }

}
