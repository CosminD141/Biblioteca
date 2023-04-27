package com.azienda.webapp.dao.concreteClass;

import java.util.List;
import javax.persistence.EntityManager;
import com.azienda.webapp.dao.factory.FactoryMysqlJPA;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.model.Genere;
import com.azienda.webapp.model.Libro;

public class LibroDaoImplJPA implements LibroDao{
	private static LibroDaoImplJPA instance;
	private LibroDaoImplJPA() {}
	
	public static LibroDaoImplJPA getInstance() {
		if(instance == null) {
			instance = new LibroDaoImplJPA();
		}
		return instance;
	}

	@Override
	public List<Libro> findAll() {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		List<Libro> libri = manager.createNamedQuery("Libro.findAll",Libro.class).getResultList();
		for(Libro libro : libri) {
			int id = libro.getId();
			List<Genere> generi = (List<Genere>)manager.createQuery("select g from Libro l join l.generi g where l.id=:id").setParameter("id", id).getResultList();
			libro.setGenere(generi);		
		} 				
		return libri;
//		return manager.createNamedQuery("Libro.findAll",Libro.class).getResultList();
	}

	@Override
	public boolean remove(int id) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		manager.getTransaction().begin();
		int row = manager.createQuery("delete from Libro l where l.id=:id").setParameter("id", id).executeUpdate();
		manager.getTransaction().commit();
		if(row>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Libro libro) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();

		
		try {
			manager.getTransaction().begin();
			manager.persist(libro);
			manager.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		}
		return false;
	}

	@Override
	public List<Libro> findByGenere(String genere) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		List<Libro> libri =(List<Libro>) manager.createQuery("select l from Libro l join l.generi g where g.nome=:genere").setParameter("genere", genere).getResultList();
		return libri;	
	}
	
	public Libro findById(int id) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		Libro libro = manager.createQuery("select l from Libro l join l.generi genere where l.id=:id", Libro.class).setParameter("id", id).getSingleResult();
		List<Genere> generi = (List<Genere>) manager.createQuery("select g from Libro l join l.generi g where l.id=:id").setParameter("id", id).getResultList();
		libro.setGenere(generi);
		return libro;
	}
	
	public List<Libro> findByTitolo(String titolo){
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return (List<Libro>)manager.createQuery("select l from Libro l where l.titolo like :titolo").setParameter("titolo", titolo).getResultList();
	}
	@Override
	public void updateNumeroCopie(Libro libro) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(libro);
		manager.getTransaction().commit();
	}

	@Override
	public List<Libro> findByUtente(int idUtente) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		List<Libro> libri = (List<Libro>)manager.createQuery("select l from Libro l join l.utenti u where u.id=:id").setParameter("id", idUtente).getResultList();
		return libri;
	}
}
