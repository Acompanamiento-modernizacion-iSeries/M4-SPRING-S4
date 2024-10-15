package com.bancolombia.aplicacionbancaria.repository;

import com.bancolombia.aplicacionbancaria.entity.TransaccionDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<TransaccionDTO, Long> {
}
