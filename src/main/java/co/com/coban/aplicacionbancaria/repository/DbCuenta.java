package co.com.coban.aplicacionbancaria.repository;

import co.com.coban.aplicacionbancaria.entity.Cuenta;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Repository
public class DbCuenta {
    Set<Cuenta> cuentas = new HashSet<>();

    public DbCuenta() {
        poblarCuentas();
    }


    public void poblarCuentas() {
        Cuenta cuenta1 = new Cuenta("Goku","Cuenta de ahorros", new BigDecimal("1000.00"));
        agregarCuenta(cuenta1);
        Cuenta cuenta2 = new Cuenta("Vegeta","Cuenta corriente", new BigDecimal("2000.00"));
        agregarCuenta(cuenta2);
        Cuenta cuenta3 = new Cuenta("Gohan","Cuenta de ahorros", new BigDecimal("3000.00"));
        agregarCuenta(cuenta3);
        Cuenta cuenta4 = new Cuenta("Trunks","Cuenta corriente", new BigDecimal("4000.00"));
        agregarCuenta(cuenta4);
        Cuenta cuenta5 = new Cuenta("Goten","Cuenta de ahorros", new BigDecimal("5000.00"));
        agregarCuenta(cuenta5);
        Cuenta cuenta6 = new Cuenta("Piccolo","Cuenta corriente", new BigDecimal("6000.00"));
        agregarCuenta(cuenta6);
        Cuenta cuenta7 = new Cuenta("Krillin","Cuenta de ahorros", new BigDecimal("7000.00"));
        agregarCuenta(cuenta7);
        Cuenta cuenta8 = new Cuenta("Yamcha","Cuenta corriente", new BigDecimal("8000.00"));
        agregarCuenta(cuenta8);
        Cuenta cuenta9 = new Cuenta("Tenshinhan","Cuenta de ahorros", new BigDecimal("9000.00"));
        agregarCuenta(cuenta9);
        Cuenta cuenta10 = new Cuenta("Chaoz","Cuenta corriente", new BigDecimal("10000.00"));
        agregarCuenta(cuenta10);
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Cuenta obtenerCuenta(Long id) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getId().equals(id)) {
                return cuenta;
            }
        }
        return null;
    }

    public Set<Cuenta> obtenerCuentas() {
        return cuentas;
    }
}
