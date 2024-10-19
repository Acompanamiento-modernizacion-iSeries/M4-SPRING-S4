package co.com.coban.aplicacionbancaria.service;

import co.com.coban.aplicacionbancaria.entity.Cuenta;
import co.com.coban.aplicacionbancaria.entity.TipoTransaccion;
import co.com.coban.aplicacionbancaria.entity.Transaccion;
import co.com.coban.aplicacionbancaria.repository.CuentaRepository;
import co.com.coban.aplicacionbancaria.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransaccionServiceImpl implements TransaccionService {
    private TransaccionRepository transaccionRepository;
    private CuentaRepository cuentaRepository;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository, CuentaRepository cuentaRepository) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void depositar(Long cuentaId, LocalDateTime fecha, String monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        Transaccion transaccion = Transaccion.builder()
                .tipo(TipoTransaccion.DEPOSITO)
                .fecha(fecha)
                .monto(new BigDecimal(monto))
                .cuenta(cuenta)
                .build();
        cuenta.setSaldo(cuenta.getSaldo().add(transaccion.getMonto()));
        cuentaRepository.save(cuenta);
    }

    @Override
    public void retirar(Long cuentaId, LocalDateTime fecha, String monto) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        Transaccion transaccion = Transaccion.builder()
                .tipo(TipoTransaccion.RETIRO)
                .fecha(fecha)
                .monto(new BigDecimal(monto))
                .cuenta(cuenta)
                .build();
        cuenta.setSaldo(cuenta.getSaldo().subtract(transaccion.getMonto()));
    }

    @Override
    public void transferir(Long cuentaOrigenId, Long cuentaDestinoId, String fecha, String monto) {
        Cuenta cuentaOrigen = cuentaRepository.findById(cuentaOrigenId).orElseThrow(() -> new RuntimeException("Cuenta origen no encontrada"));
        Cuenta cuentaDestino = cuentaRepository.findById(cuentaDestinoId).orElseThrow(() -> new RuntimeException("Cuenta destino no encontrada"));
        if (cuentaOrigen.getSaldo().compareTo(new BigDecimal(monto)) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        if (cuentaOrigen.equals(cuentaDestino)) {
            throw new RuntimeException("No se puede transferir a la misma cuenta");
        }
        if (monto.equals("0")) {
            throw new RuntimeException("El monto a transferir debe ser mayor a 0");
        }
        cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(new BigDecimal(monto)));
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(new BigDecimal(monto)));
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);
    }

    @Override
    public void consultarTransaccionesPorFecha(LocalDateTime fecha) {
        List<Transaccion> transacciones = transaccionRepository.findByFecha(fecha);
        if (transacciones.isEmpty()) {
            throw new RuntimeException("No se encontraron transacciones para la fecha indicada");
        }
    }

    @Override
    public void consultarTransaccionesPorTipo(String tipo) {
        List<Transaccion> transacciones = transaccionRepository.findByTipo(TipoTransaccion.valueOf(tipo));
        if (transacciones.isEmpty()) {
            throw new RuntimeException("No se encontraron transacciones para el tipo indicado");
        }
    }

}
