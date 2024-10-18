package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.model.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByNroCuenta(String nroCuenta);
 }
