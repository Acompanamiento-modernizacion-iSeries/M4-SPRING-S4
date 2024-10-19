package co.com.coban.aplicacionbancaria.repository;

import co.com.coban.aplicacionbancaria.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Cuenta findByNombre(String nombre);
}
