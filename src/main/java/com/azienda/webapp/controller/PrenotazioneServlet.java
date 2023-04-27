package com.azienda.webapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.dao.interfaces.PrenotazioneDao;
import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Prenotazione;
import com.azienda.webapp.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Prenotazione")
public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		if (utente != null) {
			LibroDao libroDao = factory.getLibroDao();
			int idLibro = Integer.parseInt(request.getParameter("id"));
			Libro libro = libroDao.findById(idLibro);
			request.getSession().setAttribute("libroDaAcquistare", libro);
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("WEB-INF/jsp/Prenotazione.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		Utente utente = (Utente)request.getSession().getAttribute("utente");
		String dataString = request.getParameter("dataRitiro");
		LocalDate dataRitiro = LocalDate.parse(dataString);
		LocalDate dataOdierna = LocalDate.now();
		Libro libro = (Libro)request.getSession().getAttribute("libroDaAcquistare");
		int copieRimaste = libro.getNumeroCopie();
		libro.setNumeroCopie(copieRimaste-1);
		libroDao.updateNumeroCopie(libro);
		Prenotazione p = new Prenotazione(dataOdierna, dataRitiro, libro, utente);
		prenotazioneDao.savePrenotazione(p);
		request.setAttribute("esito", "Prenotazione completata con ");
		request.setAttribute("libro", libro);
		request.getRequestDispatcher("WEB-INF/jsp/Prenotazione.jsp").forward(request, response);
		
	}

}
