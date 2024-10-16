package com.bancolombia.aplicacioncuenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancolombia.aplicacioncuenta.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}