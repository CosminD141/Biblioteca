package com.azienda.webapp.controller;

import java.io.IOException;
import java.util.List;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.dao.interfaces.UtenteDao;
import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/PersonalHomePage")
public class PersonalHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente)request.getSession().getAttribute("utente");
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
//		LibroDao libroDao = LibroDaoImplJDBC.getInstance();
		List<Libro> libri = libroDao.findAll();
		if(u!=null) {
		request.setAttribute("listaLibri", libri);
		request.getRequestDispatcher("WEB-INF/jsp/PersonalHomePage.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*GESTIONE PREFERITI*/
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		UtenteDao utenteDao = factory.getUtenteDao();
		int id = Integer.parseInt(request.getParameter("id")); // TROVO LIBRO 
		Libro libro = libroDao.findById(id);								   
		Utente u =(Utente) request.getSession().getAttribute("utente"); // RECUPERO L'UTENTE
		List<Libro> l = u.getLibri(); // RECUPERO LISTA LIBRI DELL'UTENTE
		l.add(libro); // AGGIUNGO LIBRO ALLA LISTA
		u.setLibri(l); // SETTO LA NUOVA LISTA
		utenteDao.updateRuoloUtente(u); // AGGIORNO L'UTENTE
		request.getSession().setAttribute("libri", l);
		List<Libro> allLibri = libroDao.findAll();
//		request.setAttribute("idPrefe", id);
		request.setAttribute("listaLibri", allLibri);
		request.getRequestDispatcher("WEB-INF/jsp/PersonalHomePage.jsp").forward(request, response);
	}

}
