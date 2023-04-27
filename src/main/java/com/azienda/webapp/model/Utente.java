package com.azienda.webapp.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Utente.findAll", query = "select u from Utente u") })
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false, unique = true)
	private String password;
	@ManyToOne
	@JoinColumn(name = "fk_ruolo")
	private Ruolo ruolo;
	@OneToMany(mappedBy = "utente")
	private List<Prenotazione> prenotazioni;
	
	/*RELAZIONE A LIBRO(PREFERITI)*/
	@ManyToMany
	@JoinTable(
			name= "preferiti",
			joinColumns=@JoinColumn(name="fk_utente"),
			inverseJoinColumns=@JoinColumn(name="fk_libro"))
	private List<Libro> libri;
	
	public Utente() {
	}

	public Utente(String nome, String cognome, String username, String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;

	}

	public Utente(int id, String nome, String cognome, String username, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public Utente(String nome, String cognome, String username, String password, Ruolo ruolo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}

	public Utente(int id, String nome, String cognome, String username, String password, Ruolo ruolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	

	public Utente(int id, String nome, String cognome, String username, String password, Ruolo ruolo,
			List<Prenotazione> prenotazioni, List<Libro> libri) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
		this.prenotazioni = prenotazioni;
		this.libri = libri;
	}

	public Utente(int id, String nome, String cognome, String username, String password, Ruolo ruolo,
			List<Prenotazione> prenotazioni) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
		this.prenotazioni = prenotazioni;
	}

	public Utente(Ruolo ruolo) {
		super();
		this.ruolo = ruolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", password="
				+ password + ", ruolo=" + ruolo + "]";
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, id, libri, nome, password, prenotazioni, ruolo, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(cognome, other.cognome) && id == other.id 
				&& Objects.equals(nome, other.nome) && Objects.equals(password, other.password)
				&& Objects.equals(prenotazioni, other.prenotazioni) && ruolo.getDescrizione().equals(other.getRuolo().getDescrizione())
				&& Objects.equals(username, other.username);
	}
	
	
	
}
