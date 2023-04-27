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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Libro.findAll", query = "select l from Libro l") })
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String autore;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private String annoPubblicazione;
	@Column(nullable = false, name = "numeroCopie")
	private int numeroCopie;
	@Column
	private String foto;

	@ManyToMany
	@JoinTable(name = "libro_genere", joinColumns = @JoinColumn(name = "fk_libro"), inverseJoinColumns = @JoinColumn(name = "fl_genere"))
	private List<Genere> generi;
	@OneToMany(mappedBy = "libro")
	private List<Prenotazione> prenotazioni;
	/* Relazione con Utente */
	@ManyToMany(mappedBy = "libri")
	private List<Utente> utenti;

	public Libro() {
	}

	public Libro(String autore, String titolo, String annoPubblicazione) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
	}

	public Libro(String autore, String titolo, String annoPubblicazione, List<Genere> generi) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.generi = generi;
	}

	public Libro(String autore, String titolo, String annoPubblicazione, int numeroCopie, List<Genere> generi) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopie = numeroCopie;
		this.generi = generi;
	}

	public Libro(int id, String autore, String titolo, String annoPubblicazione, int numeroCopie, List<Genere> generi) {
		super();
		this.id = id;
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopie = numeroCopie;
		this.generi = generi;
	}

	public Libro(String autore, String titolo, String annoPubblicazione, int numeroCopie, List<Genere> generi,
			List<Prenotazione> prenotazioni) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopie = numeroCopie;
		this.generi = generi;
		this.prenotazioni = prenotazioni;
	}

	public Libro(int id, String autore, String titolo, String annoPubblicazione, int numeroCopie, List<Genere> generi,
			List<Prenotazione> prenotazioni) {
		super();
		this.id = id;
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopie = numeroCopie;
		this.generi = generi;
		this.prenotazioni = prenotazioni;
	}

	public Libro(String autore, String titolo, String annoPubblicazione, int numeroCopie, String foto,
			List<Genere> generi, List<Prenotazione> prenotazioni) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopie = numeroCopie;
		this.foto = foto;
		this.generi = generi;
		this.prenotazioni = prenotazioni;
	}

	public Libro(String autore, String titolo, String annoPubblicazione, int numeroCopie, String foto,
			List<Genere> generi) {
		super();
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopie = numeroCopie;
		this.foto = foto;
		this.generi = generi;
	}

	public Libro(int id, String autore, String titolo, String annoPubblicazione, int numeroCopie, String foto,
			List<Genere> generi, List<Prenotazione> prenotazioni, List<Utente> utenti) {
		super();
		this.id = id;
		this.autore = autore;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopie = numeroCopie;
		this.foto = foto;
		this.generi = generi;
		this.prenotazioni = prenotazioni;
		this.utenti = utenti;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autore=" + autore + ", titolo=" + titolo + ", annoPubblicazione="
				+ annoPubblicazione + ", copie =" + numeroCopie + "]";
	}

	public List<Genere> getGenere() {
		return generi;
	}

	public void setGenere(List<Genere> generi) {
		this.generi = generi;
	}

	public int getNumeroCopie() {
		return numeroCopie;
	}

	public void setNumeroCopie(int numeroCopie) {
		this.numeroCopie = numeroCopie;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public String getGeneriNomi() {
		String generi = "";
		if (this.generi.size() > 1) {
			for (Genere g : this.generi) {

				generi += g.getNome() + ", ";
			} 
			StringBuilder builder = new StringBuilder(generi);
			generi = builder.substring(0,builder.length()-2);
		}else if(this.generi.size()==1) {
			generi = this.generi.get(0).getNome();
		}
		return generi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(annoPubblicazione, autore, foto, generi, id, numeroCopie, prenotazioni, titolo, utenti);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(annoPubblicazione, other.annoPubblicazione) && Objects.equals(autore, other.autore)
				&& Objects.equals(foto, other.foto) && this.getGeneriNomi().equals(other.getGeneriNomi()) && id == other.id
				&& numeroCopie == other.numeroCopie
				&& Objects.equals(titolo, other.titolo);
	}
	
	
}
