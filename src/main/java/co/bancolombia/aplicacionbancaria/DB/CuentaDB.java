package co.bancolombia.aplicacionbancaria.DB;

import co.bancolombia.aplicacionbancaria.model.Cuenta;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaDB {
    private static List<Cuenta> cuentas  = new ArrayList<>();

    public CuentaDB(){
        CuentaDB.agregarCuenta(new Cuenta("1111", new BigDecimal("500")));
        CuentaDB.agregarCuenta(new Cuenta("2222", new BigDecimal("1000")));
        CuentaDB.agregarCuenta(new Cuenta("3333", new BigDecimal("1500")));
        CuentaDB.agregarCuenta(new Cuenta("4444", new BigDecimal("2000")));
        CuentaDB.agregarCuenta(new Cuenta("5555", new BigDecimal("2500")));
    }

    public static void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public static Cuenta buscarCuenta(String nroCuenta) {
        Cuenta cta = null;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.consultarCuenta().equals(nroCuenta)) {
                cta = cuenta;
                return cta;
            }
        }
        if (cta == null) {
            throw new NullPointerException("¡La cuenta no existe en el sistema!");
        }
        return null;
    }

}
