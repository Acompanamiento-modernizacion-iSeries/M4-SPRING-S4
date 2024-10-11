package com.bancolombia.sistemabancario.sistemabancario.repository;

import com.bancolombia.sistemabancario.sistemabancario.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

}
