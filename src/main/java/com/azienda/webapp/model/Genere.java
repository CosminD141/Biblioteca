package com.azienda.webapp.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genere {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idGenere")
	private int id;
	@Column(nullable = false, unique = true)
	private String nome;
	@ManyToMany(mappedBy = "generi")
	private List<Libro> libri;
	
	public Genere() {}
	
	public Genere(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Genere(String nome) {
		super();
		this.nome = nome;
	}
	
	public Genere(int id, String nome, List<Libro> libri) {
		super();
		this.id = id;
		this.nome = nome;
		this.libri = libri;
	}

	public Genere(String nome, List<Libro> libri) {
		super();
		this.nome = nome;
		this.libri = libri;
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

	@Override
	public String toString() {
		return  nome ;
	}

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, libri, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genere other = (Genere) obj;
		return id == other.id && Objects.equals(libri, other.libri) && Objects.equals(nome, other.nome);
	}
	
}
