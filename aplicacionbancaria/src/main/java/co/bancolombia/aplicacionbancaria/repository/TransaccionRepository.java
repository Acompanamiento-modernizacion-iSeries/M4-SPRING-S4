package co.bancolombia.aplicacionbancaria.repository;

import co.bancolombia.aplicacionbancaria.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
