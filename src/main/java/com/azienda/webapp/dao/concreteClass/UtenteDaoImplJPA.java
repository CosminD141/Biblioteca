package com.azienda.webapp.dao.concreteClass;

import java.util.List;

import javax.persistence.EntityManager;
import com.azienda.webapp.dao.factory.FactoryMysqlJPA;
import com.azienda.webapp.dao.interfaces.UtenteDao;
import com.azienda.webapp.model.Ruolo;
import com.azienda.webapp.model.Utente;

public class UtenteDaoImplJPA implements UtenteDao {
	private static UtenteDaoImplJPA instance;

	private UtenteDaoImplJPA() {
	}

	public static UtenteDaoImplJPA getInstance(){
		if (instance == null) {
			instance = new UtenteDaoImplJPA();
		}
		return instance;
	}

	@Override
	public boolean findByUsernameAndPassword(String username, String password) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		List<Utente> utenti = manager.createNamedQuery("Utente.findAll", Utente.class).getResultList();
		for(Utente utente : utenti) {
			if(utente.getUsername().equalsIgnoreCase(username) && utente.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Utente> findAll() {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createNamedQuery("Utente.findAll", Utente.class).getResultList();
	}

	@Override
	public void save(Utente utente) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		try {
			manager.getTransaction().begin(); 
			manager.persist(utente); 
			manager.getTransaction().commit(); 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public String findNameByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findRuoloByUsername(String username) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createQuery("select u from Utente u where u.username=:username", Utente.class).setParameter("username", username).getSingleResult();
	}

	@Override
	public void updateRuoloUtente(Utente utente) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();

		manager.getTransaction().begin();
		manager.merge(utente);
		manager.getTransaction().commit();
	}

	@Override
	public Utente findUtenteById(int id) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();

		return manager.createQuery("select u from Utente u where u.id=:id", Utente.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Utente findUtenteByUsername(String username) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();

		return manager.createQuery("select u from Utente u where u.username=:username", Utente.class).setParameter("username", username).getSingleResult();
	}

	@Override
	public void updateUsername(Utente utente) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(utente);
		manager.getTransaction().commit();		
	}

	@Override
	public void updatePassword(Utente utente) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(utente);
		manager.getTransaction().commit();
	}

	@Override
	public List<Utente> findUtenteByRuolo(Ruolo ruolo) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createQuery("select u from Utente u where u.ruolo=:ruolo",Utente.class).setParameter("ruolo", ruolo).getResultList();
	}
}
