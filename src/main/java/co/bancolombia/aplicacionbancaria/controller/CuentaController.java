package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.model.dto.CrearCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.dto.CuentaDTO;
import co.bancolombia.aplicacionbancaria.model.dto.DepositoRetiroDTO;
import co.bancolombia.aplicacionbancaria.model.dto.NumeroCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.entity.Cuenta;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController()
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService){
        this.cuentaService = cuentaService;
    }

    @GetMapping("/saldo-id")
    public ResponseEntity<String> obtenerSaldoPorId(@Valid @RequestBody CuentaDTO cuentaDTO) {
        System.out.println(cuentaDTO.toString());
        BigDecimal saldo = cuentaService.obtenerSaldoId(cuentaDTO);
        String     mensaje = "El saldo actual es: "+ saldo;
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @GetMapping("/saldo")
    public ResponseEntity<String> obtenerSaldoPorCuenta(@Valid @RequestBody NumeroCuentaDTO numeroCuentaDTO) {
        System.out.println(numeroCuentaDTO.toString());
        BigDecimal saldo = cuentaService.obtenerSaldoCuenta(numeroCuentaDTO);
        String     mensaje = "El saldo actual es: "+ saldo;
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/crear-cuenta")
    public ResponseEntity<String> registrarCuenta(@Valid @RequestBody CrearCuentaDTO crearCuentaDTO){
        Cuenta cuentaCreada = cuentaService.crearCuenta(crearCuentaDTO);
        String mensaje =  "REGISTRO EXITOSO!!!\n\n"  ;
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PostMapping("/deposito")
    public ResponseEntity<String> depositoCuenta(@Valid @RequestBody DepositoRetiroDTO depositoRetiroDTO) throws Exception {
        Cuenta depositoCreada = cuentaService.deposito(depositoRetiroDTO);
        String mensaje =  "DEPOSITO EXITOSO!!!\n\n"  ;
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
    @PostMapping("/retiro")
    public ResponseEntity<String> retiroCuenta(@Valid @RequestBody DepositoRetiroDTO depositoRetiroDTO) throws Exception {
        Cuenta depositoCreada = cuentaService.retiro(depositoRetiroDTO);
        String mensaje =  "RETIRO EXITOSO!!!\n\n"  ;
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
/*
    @PostMapping("/deposito")
    public String depositar(@Valid @RequestBody TransaccionCuentaMontoDTO trx) {
        System.out.println(trx.toString());
        return cuentaService.depositar(trx.getCuentaID(), trx.getMonto());
    }

    @PostMapping("/retiro")
    public String retirar(@Valid @RequestBody TransaccionCuentaMontoDTO trx) {
        System.out.println(trx.toString());
        return cuentaService.retirar(trx.getCuentaID(), trx.getMonto());
    }*/
}
