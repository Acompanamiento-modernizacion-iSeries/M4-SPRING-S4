package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.model.dto.BuscarCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.dto.CrearCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.dto.CuentaDTO;
import co.bancolombia.aplicacionbancaria.model.dto.NumeroCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.entity.Cuenta;
import co.bancolombia.aplicacionbancaria.repository.ICuentaRepository;
import co.bancolombia.aplicacionbancaria.repository.ITransaccionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuentaService {

    private final ICuentaRepository cuentaRepository;
    private final ITransaccionRepository transaccionRepository;

    public CuentaService(ICuentaRepository cuentaRepository, ITransaccionRepository transaccionRepository) {
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    @Transactional
    public BigDecimal obtenerSaldoId(CuentaDTO cuentaDTO){
        Long id = cuentaDTO.getId();
        Cuenta cuenta = obtenerCuentaById(id);
        return  cuenta.getMonto();
    }

    @Transactional
    public BigDecimal obtenerSaldoCuenta(NumeroCuentaDTO nroCuentaDTO){
        String nroCuenta = nroCuentaDTO.getNroCuenta();
        Cuenta cuenta = obtenerCuenta(nroCuenta);
        return  cuenta.getMonto();
    }

    public Cuenta obtenerCuenta(String nroCuenta){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findByNroCuenta(nroCuenta);
        if (cuentaEncontrada.isEmpty()){
            throw new NoSuchElementException("La Cuenta " + nroCuenta + " No fue encontrada");
        }
        return  cuentaEncontrada.get();
    }

    public Cuenta obtenerCuentaById(Long idCuenta){
        Optional<Cuenta> cuentaEncontrada = cuentaRepository.findById(idCuenta);
        if (cuentaEncontrada.isEmpty()){
            throw new NoSuchElementException("La Cuenta con Id " + idCuenta + " No fue encontrada");
        }
        return  cuentaEncontrada.get();
    }

    @Transactional
    public Cuenta crearCuenta(CrearCuentaDTO crearCuentaDTO){
        Cuenta cuenta = new Cuenta();
        cuenta.setNroCuenta(crearCuentaDTO.getNroCuenta());
        cuenta.setNombreTitular(crearCuentaDTO.getTitular());
        cuenta.setMonto(crearCuentaDTO.getMonto());
        Cuenta cuentaNueva = cuentaRepository.save(cuenta);
        if (cuentaNueva == null) {
            throw new RuntimeException("¡No se pudo crear la cuenta!");
        }
        return cuentaNueva;
    }

}
