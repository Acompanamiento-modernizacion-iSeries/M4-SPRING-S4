package com.taller4.william.bancolombia.app.repository;

import com.taller4.william.bancolombia.app.modelo.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}