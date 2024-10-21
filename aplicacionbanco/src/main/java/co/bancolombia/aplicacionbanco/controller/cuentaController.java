package co.bancolombia.aplicacionbanco.controller;

import co.bancolombia.aplicacionbanco.model.Cuenta;
import co.bancolombia.aplicacionbanco.model.DTO.BuscarCuentaDTO;
import co.bancolombia.aplicacionbanco.model.DTO.IngresarCuentaDTO;
import co.bancolombia.aplicacionbanco.model.Transaccion;
import co.bancolombia.aplicacionbanco.service.cuentaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;


import java.math.BigDecimal;

@RestController
@RequestMapping("/Cuenta")
public class cuentaController {

    private  cuentaService cuentaservice;
    public cuentaController(cuentaService cuentaservice){

        this.cuentaservice = cuentaservice;
    }

    @GetMapping("/buscarcuenta/")
    public String obtenerSaldo(@Valid @RequestBody BuscarCuentaDTO buscarCuenta) {
        Cuenta infoCuenta = cuentaservice.obtenerInfoCuenta(buscarCuenta);
        return infoCuenta.toString();
    }

    @GetMapping("/ingresarcuenta")
    public String ingresarCuenta(@Valid @RequestBody IngresarCuentaDTO ingresarCuenta){
        Cuenta infoCuenta = cuentaservice.registrarCuenta(ingresarCuenta);
        return "Cuenta creada exitosamente" + infoCuenta.toString();
    }

}




