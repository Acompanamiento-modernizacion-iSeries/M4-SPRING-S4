package co.com.bancolombia.aplicacionbancaria.service;

import co.com.bancolombia.aplicacionbancaria.dto.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.model.Cuenta;
import co.com.bancolombia.aplicacionbancaria.model.Transaccion;
import co.com.bancolombia.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransaccionService {

    private final TransaccionRepository TRANSACCIONES_DB;

    public TransaccionService(TransaccionRepository transacciones_db) {
        TRANSACCIONES_DB = transacciones_db;
    }

    public void agregarTransaccion(TransaccionDTO transaccionDTO, String tipoTransacc, Cuenta cuenta) {
        TRANSACCIONES_DB.save(new Transaccion(
                cuenta,
                tipoTransacc,
                transaccionDTO.monto(),
                transaccionDTO.descripcion(),
                new Date()
        ));
    }
}
