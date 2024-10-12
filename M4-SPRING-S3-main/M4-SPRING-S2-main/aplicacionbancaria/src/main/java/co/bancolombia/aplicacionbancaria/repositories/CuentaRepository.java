package co.bancolombia.aplicacionbancaria.repositories;

import co.bancolombia.aplicacionbancaria.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Long>{
    Optional<Cuenta> findBynumeroCuenta(String numeroCuenta);
}
