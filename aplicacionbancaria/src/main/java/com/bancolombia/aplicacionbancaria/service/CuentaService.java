package com.bancolombia.aplicacionbancaria.service;

import com.bancolombia.aplicacionbancaria.model.Cuenta;
import com.bancolombia.aplicacionbancaria.model.DTO.ConsultaDTO;
import com.bancolombia.aplicacionbancaria.model.DTO.TransaccionDTO;
import com.bancolombia.aplicacionbancaria.model.Transaccion;
import com.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;
import com.bancolombia.aplicacionbancaria.repository.CuentaRepository;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuentaService {

//Inyeccion de dependencias
    private final CuentaRepository repository;
    private final TransaccionRepository txRepository;

   public CuentaService(CuentaRepository repository, TransaccionRepository txRepository) {
        this.repository = repository;
        this.txRepository = txRepository;
    }

   public BigDecimal obtenerSaldo(ConsultaDTO consultaDTO){
        Optional<Cuenta> cuentaEncontrada = repository.findById(consultaDTO.getCuenta_id());
        if(cuentaEncontrada.isEmpty()){
            throw new NoSuchElementException("La cuenta " + consultaDTO.getCuenta_id() + " no fue encontrada");
        }
        return cuentaEncontrada.get().getSaldo();
    }
   public BigDecimal obtenerSaldo1(TransaccionDTO transaccionDTO) {
       Cuenta cuenta = repository.findById(transaccionDTO.getCuenta())
               .orElseThrow(() -> new NoSuchElementException("La cuenta " + transaccionDTO.getCuenta() + " no fue encontrada"));
       return cuenta.getSaldo();
   }


    public Transaccion ejecutaTransaccion(TransaccionDTO transaccionDTO){
        //Consultar cuenta
        Cuenta cuenta = repository.findById(transaccionDTO.getCuenta())
                .orElseThrow(() -> new NoSuchElementException("La cuenta " + transaccionDTO.getCuenta() + " no fue encontrada"));

        //Actualizar saldo dependiendo del tipo de transaccion
        if (transaccionDTO.getTipoTransaccion().equals("depósito")) {
            cuenta.setSaldo(cuenta.getSaldo().add(transaccionDTO.getMonto()));
        } else if (transaccionDTO.getTipoTransaccion().equals("retiro")) {
            if (cuenta.getSaldo().compareTo(transaccionDTO.getMonto()) < 0) {
                throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro");
            }
            cuenta.setSaldo(cuenta.getSaldo().subtract(transaccionDTO.getMonto()));
        }

        //Guardar en tabla de cuenta
        repository.save(cuenta);

        //Crear registros de la transaccion
        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaId1(cuenta);
        transaccion.setTipoTransaccion(transaccionDTO.getTipoTransaccion());
        transaccion.setMonto(transaccionDTO.getMonto());
        transaccion.setDescripcion("Transacción de tipo: " + transaccionDTO.getTipoTransaccion());

        //Guardar la transacción en la base de datos
        return txRepository.save(transaccion);

    }

}
