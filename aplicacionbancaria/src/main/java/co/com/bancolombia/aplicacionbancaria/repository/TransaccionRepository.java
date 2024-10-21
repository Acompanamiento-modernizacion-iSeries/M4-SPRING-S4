package co.com.bancolombia.aplicacionbancaria.repository;
import co.com.bancolombia.aplicacionbancaria.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository <Transaccion, Long>{
}
