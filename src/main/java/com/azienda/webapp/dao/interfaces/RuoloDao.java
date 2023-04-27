package com.azienda.webapp.dao.interfaces;

import java.util.List;

import com.azienda.webapp.model.Ruolo;

public interface RuoloDao {
	Ruolo findRuoloByName(String nome); 
	List<Ruolo> findAll();
}
