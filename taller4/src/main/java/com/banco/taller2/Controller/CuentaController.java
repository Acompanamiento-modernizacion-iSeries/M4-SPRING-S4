package com.banco.taller2.Controller;
import com.banco.taller2.DTO.CuentaDTO;
import com.banco.taller2.DTO.TransaccionDTO;
import com.banco.taller2.Service.CuentaService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")

public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(@RequestBody CuentaDTO cuentaDTO){
        System.out.println(cuentaDTO.toString());
        return cuentaService.obtenerSaldo(cuentaDTO);
    }

    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        cuentaService.depositar(Long.parseLong(transaccionDTO.getCuentaId()), transaccionDTO.getMonto());
        return "Depósito realizado correctamente";
    }

    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionDTO transaccionDTO) {
        cuentaService.retirar(Long.parseLong(transaccionDTO.getCuentaId()), transaccionDTO.getMonto());
        return "Retiro realizado correctamente";
    }



}


