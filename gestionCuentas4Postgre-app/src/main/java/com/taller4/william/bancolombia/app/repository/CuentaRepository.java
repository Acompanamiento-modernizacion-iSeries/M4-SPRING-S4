package com.taller4.william.bancolombia.app.repository;


import com.taller4.william.bancolombia.app.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
