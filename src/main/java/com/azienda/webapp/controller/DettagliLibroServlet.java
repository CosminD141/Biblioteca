package com.azienda.webapp.controller;

import java.io.IOException;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DettagliLibro")
public class DettagliLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		Utente u = (Utente)request.getSession().getAttribute("utente");
		String idStringa = request.getParameter("id");
		int id = Integer.parseInt(idStringa);
		Libro libro = libroDao.findById(id);
		String prenotazione = (String)request.getAttribute("prenotazione");
		if(u!=null) {
			if(prenotazione!=null) {
				request.setAttribute("prenotazione", prenotazione);
			}
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("WEB-INF/jsp/DettagliLibro.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Libro libro = libroDao.findById(id);
		int copieRimaste = libro.getNumeroCopie();
		if(copieRimaste > 0) {
			libro.setNumeroCopie(copieRimaste-1);
			libroDao.updateNumeroCopie(libro);
		}
		request.setAttribute("prenotazione", "Prenotazione effettuata con successo");
		doGet(request, response);
	}

}
