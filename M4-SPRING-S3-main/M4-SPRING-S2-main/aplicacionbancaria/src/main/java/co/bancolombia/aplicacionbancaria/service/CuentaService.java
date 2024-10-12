package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.model.Cuenta;
import co.bancolombia.aplicacionbancaria.model.Transaccion;
import co.bancolombia.aplicacionbancaria.repositories.CuentaRepository;
import co.bancolombia.aplicacionbancaria.repositories.TransaccionRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    private Map<String, Cuenta> cuentas = new HashMap<>();

    public List<Cuenta> listar (){
        return this.cuentaRepository.findAll();
    }

    public List<Transaccion> listarTransacciones (){
        return this.transaccionRepository.findAll();
    }

    public Cuenta crearCuenta(@NotNull Cuenta cuenta){
        return this.cuentaRepository.save(cuenta);
    }

    public BigDecimal obtenerSaldo(String numeroCuenta) {
        Cuenta cuenta = this.cuentaRepository.findBynumeroCuenta(numeroCuenta).get();
        return cuenta != null ?  cuenta.getSaldo() : null;
    }

    public Cuenta depositar(String numeroCuenta, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("El monto de depósito debe ser mayor que cero.");

        Cuenta cuenta = this.cuentaRepository.findBynumeroCuenta(numeroCuenta).get();
        if (cuenta != null) {
            cuenta.depositar(monto);
            this.cuentaRepository.save(cuenta);
            this.transaccionRepository.save(new Transaccion(BigDecimal.ZERO,monto, String.valueOf(LocalDateTime.now()),cuenta));
        }
        return cuenta;
    }

    public boolean retirar(String numeroCuenta, BigDecimal monto) {
        Cuenta cuenta = this.cuentaRepository.findBynumeroCuenta(numeroCuenta).get();

        if( cuenta == null )
            throw new IllegalArgumentException("El numero de cuenta: '"+numeroCuenta+"' no existe");
        if(monto.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("El monto de retiro debe ser mayor que cero.");

        this.cuentaRepository.save(cuenta);
        this.transaccionRepository.save(new Transaccion(monto,BigDecimal.ZERO, String.valueOf(LocalDateTime.now()),cuenta));
        boolean response = cuenta.retirar(monto);
        this.cuentaRepository.save(cuenta);
        return response;
    }
}
