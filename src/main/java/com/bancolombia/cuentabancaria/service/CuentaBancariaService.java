package com.bancolombia.cuentabancaria.service;

import com.bancolombia.cuentabancaria.model.entity.CuentaBancariaEntity;
import com.bancolombia.cuentabancaria.model.entity.TransaccionEntity;
import com.bancolombia.cuentabancaria.model.request.TransaccionRQ;
import com.bancolombia.cuentabancaria.repository.CuentaRepository;
import com.bancolombia.cuentabancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class CuentaBancariaService {

    private final CuentaRepository repository;
    private final TransaccionRepository transaccionRepository;

    public CuentaBancariaService(CuentaRepository repository, TransaccionRepository transaccionRepository) {
        this.repository = repository;
        this.transaccionRepository = transaccionRepository;
    }

    public boolean validSaldo(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        return true;
    }

    public CuentaBancariaEntity getCuenta(Long id){
        Optional<CuentaBancariaEntity> cuenta = repository.findById(id);
        if(cuenta == null){
            throw new NullPointerException("La Cuenta bancaria no existe");
        }
        return cuenta.get();
    }

    public CuentaBancariaEntity deposito(TransaccionRQ transaccionRQ){
        CuentaBancariaEntity cuentaEntity = getCuenta(transaccionRQ.getIdCuenta());
        if(cuentaEntity == null){
            throw new NullPointerException("La Cuenta bancaria no existe");
        }else if(validSaldo(transaccionRQ.getValor())){
            cuentaEntity.deposito(transaccionRQ.getValor());
            updateCuentaBancaria(cuentaEntity, "deposito", transaccionRQ.getValor());
        }
        return cuentaEntity;
    }

    public CuentaBancariaEntity retiro(TransaccionRQ transaccionRQ){
        CuentaBancariaEntity cuentaEntity = getCuenta(transaccionRQ.getIdCuenta());
        if(cuentaEntity == null){
            throw new NullPointerException("La Cuenta bancaria no existe");
        }else if(validSaldo(transaccionRQ.getValor())){
            cuentaEntity.retiro(transaccionRQ.getValor());
            updateCuentaBancaria(cuentaEntity, "retiro", transaccionRQ.getValor());
        }
        return cuentaEntity;
    }

    public CuentaBancariaEntity updateCuentaBancaria(CuentaBancariaEntity cuentaBancariaEntity, String tipoTransaccion,
                                                     BigDecimal valor){
        TransaccionEntity transaccion = new TransaccionEntity();
        transaccion.setCuentabancaria(cuentaBancariaEntity);
        transaccion.setTipotransaccion(tipoTransaccion);
        transaccion.setMonto(valor);
        transaccion.setFecharegistro(new Date());
        transaccionRepository.save(transaccion);
        return repository.save(cuentaBancariaEntity);
    }
}
