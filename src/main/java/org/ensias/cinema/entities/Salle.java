package org.ensias.cinema.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
public class Salle {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 75)
	private String name;
	private int nombrePlace;
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	private Cinema cinema;
	@OneToMany(mappedBy = "salle")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Place> places;
	@OneToMany(mappedBy = "salle")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Projection>projections;
	
	
	
	public Long getId() {
		return id;
	}
	public Collection<Place> getPlaces() {
		return places;
	}
	public void setPlaces(Collection<Place> places) {
		this.places = places;
	}
	public Collection<Projection> getProjections() {
		return projections;
	}
	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	public Cinema getCinema() {
		return cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	public Salle(Long id, String name, int nombrePlace, Cinema cinema) {
		super();
		this.id = id;
		this.name = name;
		this.nombrePlace = nombrePlace;
		this.cinema = cinema;
	}
	public Salle() {
		super();
	}
	

}
