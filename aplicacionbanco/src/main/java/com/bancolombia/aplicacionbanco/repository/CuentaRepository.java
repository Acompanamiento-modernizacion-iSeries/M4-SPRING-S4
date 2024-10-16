package com.bancolombia.aplicacionbanco.repository;


import com.bancolombia.aplicacionbanco.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
}
