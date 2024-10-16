package co.bancolombia.aplicacionbancaria.repository;
        import java.util.List;

        import org.springframework.stereotype.Repository;

        import java.math.BigDecimal;
        import java.util.Arrays;

        import co.bancolombia.aplicacionbancaria.models.Cuenta;

//@Repository
public class CuentasRepository {
    /*private List<Cuenta> cuentas;
    public CuentasRepository()  {
        this.cuentas = Arrays.asList(
                new Cuenta("10",  new BigDecimal(1000), "Ahorros", "Maria"),
                new Cuenta("20",  new BigDecimal(2000), "Corriente", "Camila"),
                new Cuenta("30",  new BigDecimal(3000), "Ahorros", "Felipe"),
                new Cuenta("40",  new BigDecimal(4000), "Corriente", "Laura"),
                new Cuenta("50",  new BigDecimal(5000), "Ahorros", "Monica"),
                new Cuenta("60",  new BigDecimal(6000), "Corriente", "Carlos"),
                new Cuenta("70",  new BigDecimal(7000), "Ahorros", "Pepe")
        );
    }
    public List<Cuenta> listarCuentas(){
        return cuentas;
    }
    public Cuenta buscarIdCuenta(String cuenta){
        return cuentas.stream().filter(p ->  p.getCuenta().equals(cuenta)).findFirst().orElse(null);

    }
*/

}