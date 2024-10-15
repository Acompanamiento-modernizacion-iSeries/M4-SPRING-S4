package co.bancolombia.aplicacionbancaria.service;

import co.bancolombia.aplicacionbancaria.DTO.ConsultaCuentaDTO;
import co.bancolombia.aplicacionbancaria.DTO.CreaCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.Cuenta;
import co.bancolombia.aplicacionbancaria.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class CuentaService {

    private final CuentaRepository repository;

    public CuentaService(CuentaRepository repository) {
        this.repository = repository;
    }

    public Cuenta save(CreaCuentaDTO crearDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.asignarSaldo(crearDTO.consultarSaldo());
        cuenta.asignarTitular(crearDTO.consultarTitular());
        cuenta.asignarDocumentoTitular(crearDTO.consultarDocumentoTitular());


        Cuenta cuentaNueva = repository.save(cuenta);

        if (cuentaNueva == null) {
            throw new RuntimeException("No se pudo crear la cuenta");
        }

        return cuentaNueva;
    }

    public Cuenta obtenerSaldo(ConsultaCuentaDTO consultaCuentaDTO) {
          Optional<Cuenta> cuentaEncontrada = repository.findById(consultaCuentaDTO.getNroCuenta());
          if (cuentaEncontrada.isEmpty() ) {
              throw new NoSuchElementException("La cuenta número "+ consultaCuentaDTO.getNroCuenta()+" no encontrada");
          }
          Cuenta cuenta = cuentaEncontrada.get();
          return cuenta;

    }

}
