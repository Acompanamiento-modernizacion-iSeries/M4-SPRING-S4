package co.bancolombia.aplicacionbancaria.repository;


import co.bancolombia.aplicacionbancaria.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

}