package com.azienda.webapp.dao.concreteClass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.azienda.webapp.dao.factory.FactoryMysqlJPA;
import com.azienda.webapp.dao.interfaces.RuoloDao;
import com.azienda.webapp.model.Ruolo;

public class RuoloDaoImplJPA implements RuoloDao{
	private static RuoloDaoImplJPA instance;
	private RuoloDaoImplJPA() {}
	
	public static RuoloDaoImplJPA getInstance() {
		if(instance == null) {
			instance = new RuoloDaoImplJPA();
		}
		return instance;
	}
	@Override
	public Ruolo findRuoloByName(String nome) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createQuery("select r from Ruolo r where r.descrizione =:nome", Ruolo.class).setParameter("nome", nome).getSingleResult();
	}

	@Override
	public List<Ruolo> findAll() {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createNamedQuery("Ruolo.trovaRuoli", Ruolo.class).getResultList();
	}
}
