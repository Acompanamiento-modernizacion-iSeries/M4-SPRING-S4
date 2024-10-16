package co.com.bancolombia.aplicacionbancaria.service;

import co.com.bancolombia.aplicacionbancaria.dto.CuentaDTO;
import co.com.bancolombia.aplicacionbancaria.dto.TransaccionDTO;
import co.com.bancolombia.aplicacionbancaria.model.Cuenta;
import co.com.bancolombia.aplicacionbancaria.repository.CuentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuentaService {

    private final CuentaRepository CUENTAS_DB;

    public CuentaService(CuentaRepository cuentasDb) {
        this.CUENTAS_DB = cuentasDb;
    }

    public BigDecimal consultarSaldo(CuentaDTO cuentaDTO) {
        return buscarCuenta(cuentaDTO.id()).saldo();
    }

    public BigDecimal deposito(TransaccionDTO transaccionDTO) {
        Cuenta cuenta = buscarCuenta(transaccionDTO.idCuenta());
        BigDecimal nuevoSaldo = cuenta.saldo().add(transaccionDTO.monto());

        cuenta.actualizarSaldo(nuevoSaldo);
        CUENTAS_DB.save(cuenta);

        return cuenta.saldo();
    }

    public BigDecimal retiro(TransaccionDTO transaccionDTO) {
        Cuenta cuenta = buscarCuenta(transaccionDTO.idCuenta());
        BigDecimal vlrTransacc = transaccionDTO.monto();

        if (vlrTransacc.compareTo(cuenta.saldo()) > 0)
            throw new IllegalArgumentException("No tiene fondos suficientes!");

        BigDecimal nuevoSaldo = cuenta.saldo().subtract(vlrTransacc);

        cuenta.actualizarSaldo(nuevoSaldo);
        CUENTAS_DB.save(cuenta);

        return cuenta.saldo();
    }

    public Cuenta buscarCuenta(Long idCuenta) {
        Optional<Cuenta> cuentaSelect = CUENTAS_DB.findById(idCuenta);
        if (cuentaSelect.isEmpty())
            throw new NoSuchElementException("No existe una cuenta con el id proporcionado");

        return cuentaSelect.get();
    }
}
