package co.bancolombia.aplicacionbancaria;

import co.bancolombia.aplicacionbancaria.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacionbancariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicacionbancariaApplication.class, args);
		System.out.println("Taller 2");
	}

}
