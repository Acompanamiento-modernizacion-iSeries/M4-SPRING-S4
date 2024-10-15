package com.bancolombia.cuentabancaria.repository;

import com.bancolombia.cuentabancaria.model.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<TransaccionEntity, Long> {
}
