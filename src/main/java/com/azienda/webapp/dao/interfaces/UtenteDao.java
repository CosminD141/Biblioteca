package com.azienda.webapp.dao.interfaces;

import java.util.List;

import com.azienda.webapp.model.Ruolo;
import com.azienda.webapp.model.Utente;

public interface UtenteDao {
	boolean findByUsernameAndPassword(String username, String password);
	List<Utente> findAll();
	void save(Utente utente);
	String findNameByUsername(String username);
	Utente findRuoloByUsername(String username);
	void updateRuoloUtente(Utente utente);
	Utente findUtenteById(int id);
	Utente findUtenteByUsername(String username);
	void updateUsername(Utente utente);
	void updatePassword(Utente utente);
	List<Utente> findUtenteByRuolo(Ruolo ruolo);
}
