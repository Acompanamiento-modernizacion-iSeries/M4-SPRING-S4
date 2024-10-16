package co.bancolombia.aplicacionbancaria.controllers;

import co.bancolombia.aplicacionbancaria.models.Cuenta;
import co.bancolombia.aplicacionbancaria.models.dto.BuscarCuentaDTO;
import co.bancolombia.aplicacionbancaria.models.dto.CrearCuentaDTO;
import co.bancolombia.aplicacionbancaria.services.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private CuentaService cuentaService;
    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }
    @GetMapping("/saldo")
    public String  saldo(@Valid @RequestBody BuscarCuentaDTO buscarCuentaDTO) {
        Cuenta datosCuenta = cuentaService.obtenerDatosCuenta(buscarCuentaDTO);
        return  datosCuenta.toString();
    }
    @PostMapping("crearcuenta")
    public String registrarCuenta(@Valid @RequestBody CrearCuentaDTO crearCuentaDTO){
        Cuenta datosCuenta = cuentaService.registroCuenta(crearCuentaDTO);
        return "REGISTRO EXITOSO!!!\n\n" + datosCuenta.toString();
    }

}