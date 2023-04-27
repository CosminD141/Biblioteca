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

@WebServlet("/Preferiti")
public class PreferitiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		Utente u = (Utente)request.getSession().getAttribute("utente");
		int id = u.getId();
		List<Libro> libriPreferiti = libroDao.findByUtente(id);
		request.setAttribute("preferiti", libriPreferiti);
		request.getRequestDispatcher("WEB-INF/jsp/WishList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		UtenteDao utenteDao = factory.getUtenteDao();
		Utente u = (Utente)request.getSession().getAttribute("utente"); 
		int id = u.getId();
		List<Libro> libri = libroDao.findByUtente(id);	
		int idLibro = Integer.parseInt(request.getParameter("id"));
		Libro libro = libroDao.findById(idLibro);
		System.out.println(libro);
		libri.remove(libro);
		u.setLibri(libri);
		utenteDao.updateRuoloUtente(u);
		doGet(request, response);
	}

}
