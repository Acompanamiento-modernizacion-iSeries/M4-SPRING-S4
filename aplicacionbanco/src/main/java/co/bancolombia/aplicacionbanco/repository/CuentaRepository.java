package co.bancolombia.aplicacionbanco.repository;


import co.bancolombia.aplicacionbanco.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {


    }


