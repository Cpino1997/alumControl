package cl.sustantiva.alumControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class alumControl {

	public static void main(String[] args) {
		SpringApplication.run(alumControl.class, args);
		System.out.println("Estoy Encendido!");
	}

}
