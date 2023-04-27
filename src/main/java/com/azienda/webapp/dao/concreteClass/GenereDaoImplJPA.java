package com.azienda.webapp.dao.concreteClass;

import java.util.List;
import javax.persistence.EntityManager;
import com.azienda.webapp.dao.factory.FactoryMysqlJPA;
import com.azienda.webapp.dao.interfaces.GenereDao;
import com.azienda.webapp.model.Genere;

public class GenereDaoImplJPA implements GenereDao{
	private static GenereDaoImplJPA instance;
	private GenereDaoImplJPA() {}
	
	public static GenereDaoImplJPA getInstance() {
		if(instance == null) {
			instance = new GenereDaoImplJPA();
		}
		return instance;
	}

	@Override
	public List<Genere> findAllGenere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveGenere(Genere genere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Genere findGenereByDescrizione(String descrizione) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createQuery("select g from Genere g where g.nome=:descrizione",Genere.class).setParameter("descrizione", descrizione).getSingleResult();
	}

}
