package com.azienda.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private LocalDate dataOdierna;
	@Column(nullable = false)
	private LocalDate dataConsegna;
	@Column()
	private LocalDate dataConsegnaEffettiva;
	@ManyToOne
	@JoinColumn(name = "fk_libro")
	private Libro libro;
	@ManyToOne
	@JoinColumn(name = "fk_utente")
	private Utente utente;
	
	public Prenotazione() {};
	
	public Prenotazione(int id, LocalDate dataOdierna, LocalDate dataConsegna, LocalDate dataConsegnaEffettiva,
			Libro libro, Utente utente) {
		super();
		this.id = id;
		this.dataOdierna = dataOdierna;
		this.dataConsegna = dataConsegna;
		this.dataConsegnaEffettiva = dataConsegnaEffettiva;
		this.libro = libro;
		this.utente = utente;
	}

	public Prenotazione(LocalDate dataOdierna, LocalDate dataConsegna, LocalDate dataConsegnaEffettiva, Libro libro,
			Utente utente) {
		super();
		this.dataOdierna = dataOdierna;
		this.dataConsegna = dataConsegna;
		this.dataConsegnaEffettiva = dataConsegnaEffettiva;
		this.libro = libro;
		this.utente = utente;
	}
	
	
	
	public Prenotazione(LocalDate dataOdierna, LocalDate dataConsegna, Libro libro, Utente utente) {
		super();
		this.dataOdierna = dataOdierna;
		this.dataConsegna = dataConsegna;
		this.libro = libro;
		this.utente = utente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataOdierna() {
		return dataOdierna;
	}

	public void setDataOdierna(LocalDate dataOdierna) {
		this.dataOdierna = dataOdierna;
	}

	public LocalDate getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(LocalDate dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public LocalDate getDataConsegnaEffettiva() {
		return dataConsegnaEffettiva;
	}

	public void setDataConsegnaEffettiva(LocalDate dataConsegnaEffettiva) {
		this.dataConsegnaEffettiva = dataConsegnaEffettiva;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataConsegna, dataConsegnaEffettiva, dataOdierna, id, libro, utente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenotazione other = (Prenotazione) obj;
		return Objects.equals(dataConsegna, other.dataConsegna)
				&& Objects.equals(dataConsegnaEffettiva, other.dataConsegnaEffettiva)
				&& Objects.equals(dataOdierna, other.dataOdierna) && id == other.id
				&& Objects.equals(libro, other.libro) && Objects.equals(utente, other.utente);
	}
	
	
	
}
