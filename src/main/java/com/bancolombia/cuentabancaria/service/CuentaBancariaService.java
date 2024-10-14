package com.bancolombia.cuentabancaria.service;

import com.bancolombia.cuentabancaria.model.entity.CuentaBancariaEntity;
import com.bancolombia.cuentabancaria.model.entity.TransaccionEntity;
import com.bancolombia.cuentabancaria.model.exception.DomainException;
import com.bancolombia.cuentabancaria.repository.CuentaRepository;
import com.bancolombia.cuentabancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuentaBancariaService {

    private final CuentaRepository repository;
    private final TransaccionRepository transaccionRepository;

    public CuentaBancariaService(CuentaRepository repository, TransaccionRepository transaccionRepository) {
        this.repository = repository;
        this.transaccionRepository = transaccionRepository;
    }

    public boolean validSaldo(BigDecimal valor) throws DomainException {
        if(valor.compareTo(BigDecimal.ZERO) < 0){
            throw new DomainException(1, "Saldo negativo", "El saldo no puede ser negativo");
        }
        return true;
    }

    public CuentaBancariaEntity getCuenta(Long id) throws DomainException {
        Optional<CuentaBancariaEntity> cuenta = repository.findById(id);
        if(cuenta.isEmpty()){
            throw new DomainException(2, "Cuenta no encontrada", "La cuenta no existe");
        }
        return cuenta.get();
    }

    public CuentaBancariaEntity updateCuentaBancaria(CuentaBancariaEntity cuentaBancariaEntity, String tipoTransaccion,
                                                     BigDecimal valor) throws DomainException {
        TransaccionEntity transaccion = new TransaccionEntity();
        transaccion.setCuentabancaria(cuentaBancariaEntity);
        transaccion.setTipotransaccion(tipoTransaccion);
        transaccion.setMonto(valor);
        transaccion.setFecharegistro(new Date());
        transaccionRepository.save(transaccion);
        return repository.save(cuentaBancariaEntity);
    }
}
