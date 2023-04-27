package com.azienda.webapp.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Ruolo.trovaRuoli", query="select r from Ruolo r")
public class Ruolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String descrizione;
	@OneToMany(mappedBy = "ruolo")
	private List<Utente> utenti;
	
	public Ruolo() {}

	public Ruolo(int id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}

	public Ruolo(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	@Override
	public String toString() {
		return descrizione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, id, utenti);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruolo other = (Ruolo) obj;
		return Objects.equals(descrizione, other.descrizione) && id == other.id && Objects.equals(utenti, other.utenti);
	}
	
	
	

}
