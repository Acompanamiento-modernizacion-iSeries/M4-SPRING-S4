package co.com.coban.aplicacionbancaria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    // swagger api http://localhost:8080/swagger-ui/index.html

    private BigDecimal saldo = new BigDecimal("1000.00");

    @GetMapping("/bienvenido")
    public String bienvenido() {
        return "Bienvenido, en esta sección podrá realizar operaciones con su cuenta.";
    }

    @GetMapping("/saldo")
    public BigDecimal saldo() {
        return saldo;
    }

    @PostMapping("/deposito/{monto}")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Depósito exitoso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Error en el depósito")
    })
    public String deposito(@PathVariable BigDecimal monto) {
//        saldo = saldo.add(monto);
//        return saldo;
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(monto);
            return "Depósito exitoso. Saldo actual: " + saldo;
        } else {
//            return new BigDecimal("-1");
            return "El monto a depositar debe ser mayor a cero.";
        }
    }

    @PostMapping("/deposito2/{monto}")
    @ApiResponse(responseCode = "200", description = "Depósito exitoso")
    public String deposito2(@PathVariable("monto") BigDecimal valor) {
//        saldo = saldo.add(monto);
//        return saldo;
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
            return "Depósito exitoso. Saldo actual: " + saldo;
        } else {
//            return new BigDecimal("-1");
            return "El monto a depositar debe ser mayor a cero.";
        }
    }

    // el mismo metodo anterior pero usando un query param
    @PostMapping("/deposito3")
    @ApiResponses (value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Depósito exitoso"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Error en el depósito")
    })
    @Operation(
            summary = "Depositar dinero en la cuenta",
            description = "Depositar dinero en la cuenta",
            tags = {"cuenta"},
            parameters = {
                    @io.swagger.v3.oas.annotations.Parameter(
                            name = "monto",
                            description = "Monto a depositar",
                            required = true,
                            example = "1000.00",
                            schema = @io.swagger.v3.oas.annotations.media.Schema(type = "number")
                    )
            }
    )
    public String depositoQueryParam(@RequestParam("monto") BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
            return "Depósito exitoso. Saldo actual: " + saldo;
        } else {
            return "El monto a depositar debe ser mayor a cero.";
        }
    }

}
