package com.bancolombia.aplicacionbancaria.bd;

import com.bancolombia.aplicacionbancaria.entity.Cuenta;
import com.bancolombia.aplicacionbancaria.entity.TransaccionDTO;
import com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import com.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class DataLoader {

    @Autowired
    private CuentaRepository cuentaRepository;
    private TransaccionRepository transaccionRepository;

    @PostConstruct
    public void cargarDatos() {


        cuentaRepository.save(new Cuenta("Juan Perez", BigDecimal.valueOf(5000), null));
        cuentaRepository.save(new Cuenta("Maria Rodriguez", BigDecimal.valueOf(3000), null));
        cuentaRepository.save(new Cuenta( "Pedro Gomez", BigDecimal.valueOf(15000), null));
        cuentaRepository.save(new Cuenta("Luisa Perez", BigDecimal.valueOf(20000), null));




    }
}
