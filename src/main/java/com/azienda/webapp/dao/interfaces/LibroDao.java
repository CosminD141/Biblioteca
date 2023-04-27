package com.azienda.webapp.dao.interfaces;

import java.util.List;
import com.azienda.webapp.model.Libro;

public interface LibroDao {
	List<Libro> findAll();
//	boolean removeByTitolo(String titolo);
	boolean remove(int id);
	boolean save(Libro libro);
	List<Libro> findByGenere(String genere);
//	public void saveGenere(Genere genere);
//	public int findIdByNome(Genere genere);
	Libro findById(int id);
	public void updateNumeroCopie(Libro libro);
	List<Libro> findByUtente(int idUtente);
//	List<Libro> findByPrenotazione();
}
