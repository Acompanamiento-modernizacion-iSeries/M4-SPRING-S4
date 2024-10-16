package co.bancolombia.aplicacionbancaria.Controller;

import co.bancolombia.aplicacionbancaria.model.DTO.CuentaDTO;
import co.bancolombia.aplicacionbancaria.model.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo")
    public BigDecimal obtenerSaldo(@Valid @RequestBody CuentaDTO cuentaDTO) {
        System.out.println("CuentaDTO: " + cuentaDTO.toString());
        return cuentaService.obtenerSaldo(cuentaDTO);
    }

    @PostMapping("/deposito")
    public String deposito(@Valid @RequestBody TransaccionDTO transaccionDto){
        System.out.println(transaccionDto.toString());
        return "Deposito: "+ cuentaService.deposito(transaccionDto);
    }

    @PostMapping("/retiro")
    public String retiro(@Valid @RequestBody TransaccionDTO transaccionDto) {
        System.out.println(transaccionDto.toString());
        return "Retiro: "+ cuentaService.retiro(transaccionDto);
    }
}