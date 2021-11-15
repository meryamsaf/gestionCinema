package org.ensias.cinema;

import org.ensias.cinema.service.ICinemaInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class GestionCinemaApplication implements CommandLineRunner {
	@Autowired
	private ICinemaInitService cinemaInitService;

	public static void main(String[] args) {
		SpringApplication.run(GestionCinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initFilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
		
		
	}

}
