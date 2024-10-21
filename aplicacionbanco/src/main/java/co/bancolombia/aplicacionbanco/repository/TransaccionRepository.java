package co.bancolombia.aplicacionbanco.repository;

import co.bancolombia.aplicacionbanco.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
