package com.azienda.webapp.dao.interfaces;

import java.util.List;

import com.azienda.webapp.model.Genere;

public interface GenereDao {
	public List<Genere> findAllGenere();
	public void saveGenere(Genere genere);
	Genere findGenereByDescrizione(String descrizione);
}
