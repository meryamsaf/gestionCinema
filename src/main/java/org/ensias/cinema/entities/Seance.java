package org.ensias.cinema.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Seance {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Temporal(TemporalType.TIME )
private Date heureDebut;



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public Date getHeureDebut() {
	return heureDebut;
}



public void setHeureDebut(Date heureDebut) {
	this.heureDebut = heureDebut;
}



public Seance() {
	super();
}



public Seance(Long id, Date heureDebut) {
	super();
	this.id = id;
	this.heureDebut = heureDebut;
}

}
