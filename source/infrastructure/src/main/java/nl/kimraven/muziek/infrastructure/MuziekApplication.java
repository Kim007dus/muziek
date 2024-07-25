package nl.kimraven.muziek.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "nl.kimraven.muziek")
public class MuziekApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuziekApplication.class, args);
	}

}
