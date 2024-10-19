package co.com.coban.aplicacionbancaria.service;

import java.time.LocalDateTime;

public interface TransaccionService {
    void depositar(Long cuentaId, LocalDateTime fecha, String monto);
    void retirar(Long cuentaId, LocalDateTime fecha, String monto);
    void transferir(Long cuentaOrigenId, Long cuentaDestinoId, String fecha, String monto);
    void consultarTransaccionesPorFecha(LocalDateTime fecha);
    void consultarTransaccionesPorTipo(String tipo);
}
