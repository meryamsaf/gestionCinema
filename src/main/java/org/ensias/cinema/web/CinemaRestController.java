package org.ensias.cinema.web;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import java.nio.file.Path;


import org.ensias.cinema.dao.FilmRepository;
import org.ensias.cinema.dao.TicketRepository;
import org.ensias.cinema.entities.Film;
import org.ensias.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class CinemaRestController {
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@GetMapping(path="/imageFilm/{id}", produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] image(@PathVariable (name="id")Long id) throws Exception {
		Film f = filmRepository.findById(id).get();
		String photoName = f.getPhoto();
		File file = new File(System.getProperty("user.home")+"/images/"+photoName);
		Path path = Paths.get(file.toURI());
		return Files.readAllBytes(path);
		
	
	}
	@PostMapping("/payerTickets")
	@Transactional
	public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm ){
		List<Ticket> listTickets = new ArrayList<>();
		
		ticketForm.getTickets().forEach(idTicket->{
			Ticket ticket = ticketRepository.findById(idTicket).get();
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setReserve(true);
			ticketRepository.save(ticket);
			listTickets.add(ticket);
			
			
		});
		return listTickets;
		
	}

}

class TicketForm{
	private String nomClient;
	private int codePayement;
	private List<Long> tickets = new ArrayList<>();
	
	
	
	
	public TicketForm() {
		super();
	}
	public TicketForm(String nomClient, int codePayement, List<Long> tickets) {
		super();
		this.nomClient = nomClient;
		this.codePayement = codePayement;
		this.tickets = tickets;
	}
	public int getCodePayement() {
		return codePayement;
	}
	public void setCodePayement(int codePayement) {
		this.codePayement = codePayement;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public List<Long> getTickets() {
		return tickets;
	}
	public void setTickets(List<Long> tickets) {
		this.tickets = tickets;
	}
	
}
