package co.com.coban.aplicacionbancaria.repository;

import co.com.coban.aplicacionbancaria.entity.TipoTransaccion;
import co.com.coban.aplicacionbancaria.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
    List<Transaccion> findByFecha(LocalDateTime fecha);
    List<Transaccion> findByTipo(TipoTransaccion tipo);
}
