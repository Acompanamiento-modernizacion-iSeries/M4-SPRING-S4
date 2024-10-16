package com.example.practica4.repository;

import com.example.practica4.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
