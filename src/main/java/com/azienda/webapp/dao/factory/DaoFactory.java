package com.azienda.webapp.dao.factory;

import com.azienda.webapp.dao.interfaces.GenereDao;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.dao.interfaces.PrenotazioneDao;
import com.azienda.webapp.dao.interfaces.RuoloDao;
import com.azienda.webapp.dao.interfaces.UtenteDao;

public abstract class DaoFactory {
	public abstract UtenteDao getUtenteDao();
	public abstract LibroDao getLibroDao();
	public abstract GenereDao getGenereDao();
	public abstract RuoloDao getRuoloDao();
	public abstract PrenotazioneDao getPrenotazioneDao();
	
	public static DaoFactory getFactory() {
		
			return  new FactoryMysqlJPA();

	}
}
