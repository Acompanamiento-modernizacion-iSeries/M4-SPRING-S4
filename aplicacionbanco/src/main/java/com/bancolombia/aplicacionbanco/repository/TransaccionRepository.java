package com.bancolombia.aplicacionbanco.repository;

import com.bancolombia.aplicacionbanco.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository <Transaccion, Long>{
}
