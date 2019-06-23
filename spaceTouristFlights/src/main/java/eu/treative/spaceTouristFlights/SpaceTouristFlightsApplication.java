package eu.treative.spaceTouristFlights;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpaceTouristFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceTouristFlightsApplication.class, args);
	}

}
