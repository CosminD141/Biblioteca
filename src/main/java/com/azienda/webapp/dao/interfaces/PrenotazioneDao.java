package com.azienda.webapp.dao.interfaces;

import java.util.List;

import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Prenotazione;
import com.azienda.webapp.model.Utente;

public interface PrenotazioneDao {
	List<Prenotazione> findAllPrenotazioni();
	boolean savePrenotazione(Prenotazione prenotazione);
	Prenotazione findById(int id);
	List<Prenotazione> findByLibro(Libro libro);
	List<Prenotazione> findByUtente(Utente utente);
	public void updatePrenotazione(Prenotazione p);
}
