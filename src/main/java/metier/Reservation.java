package metier;

import dao.ServiceAdherent;
import meserreurs.MonException;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the reservation database table.
 * 
 */
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Adherent adherent;
	private Oeuvrevente oeuvrevente;
	private String statut;

	public Reservation() {
	}



	public Reservation(Date date, Adherent adherent, Oeuvrevente oeuvrevente) {
		super();
		this.date = date;
		this.adherent = adherent;
		this.oeuvrevente = oeuvrevente;
	}



	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Oeuvrevente getOeuvrevente() {
		return this.oeuvrevente;
	}

	public void setOeuvrevente(Oeuvrevente oeuvrevente) {
		this.oeuvrevente = oeuvrevente;
	}

}