package co.bancolombia.aplicacionbancaria.repositories;

import co.bancolombia.aplicacionbancaria.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion ,Long> {
}
