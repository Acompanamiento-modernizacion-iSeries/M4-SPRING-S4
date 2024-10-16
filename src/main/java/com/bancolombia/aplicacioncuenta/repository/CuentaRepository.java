package com.bancolombia.aplicacioncuenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancolombia.aplicacioncuenta.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    
}
