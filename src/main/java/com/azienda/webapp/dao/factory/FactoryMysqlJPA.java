package com.azienda.webapp.dao.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.azienda.webapp.dao.concreteClass.GenereDaoImplJPA;
import com.azienda.webapp.dao.concreteClass.LibroDaoImplJPA;
import com.azienda.webapp.dao.concreteClass.PrenotazioneDaoImplJPA;
import com.azienda.webapp.dao.concreteClass.RuoloDaoImplJPA;
import com.azienda.webapp.dao.concreteClass.UtenteDaoImplJPA;
import com.azienda.webapp.dao.interfaces.GenereDao;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.dao.interfaces.PrenotazioneDao;
import com.azienda.webapp.dao.interfaces.RuoloDao;
import com.azienda.webapp.dao.interfaces.UtenteDao;

public class FactoryMysqlJPA extends DaoFactory{
	public static EntityManager getEntityManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Biblioteca");
		factory.getCache().evictAll();
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	@Override
	public UtenteDao getUtenteDao() {
		return UtenteDaoImplJPA.getInstance();
	}

	@Override
	public LibroDao getLibroDao() {
		return LibroDaoImplJPA.getInstance();
	}

	@Override
	public GenereDao getGenereDao() {
		return GenereDaoImplJPA.getInstance();
	}

	@Override
	public RuoloDao getRuoloDao() {
		return RuoloDaoImplJPA.getInstance();
	}

	@Override
	public PrenotazioneDao getPrenotazioneDao() {
		return PrenotazioneDaoImplJPA.getInstance();
	}
}
