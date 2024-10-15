package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.modelo.CuentaBanco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository  extends JpaRepository<CuentaBanco, Long> {
    Optional<CuentaBanco> findByNroCuenta(String nroCuenta);
}
