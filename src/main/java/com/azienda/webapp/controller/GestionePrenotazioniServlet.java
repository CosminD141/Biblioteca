package com.azienda.webapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.PrenotazioneDao;
import com.azienda.webapp.model.Prenotazione;
import com.azienda.webapp.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GestionePrenotazioni")
public class GestionePrenotazioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente admin = (Utente)request.getSession().getAttribute("admin");
		DaoFactory factory = DaoFactory.getFactory();
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		List<Prenotazione> prenotazioni = prenotazioneDao.findAllPrenotazioni();
		if(admin!=null) {
			request.setAttribute("prenotazioni", prenotazioni);
			request.getRequestDispatcher("WEB-INF/jsp/GestionePrenotazioni.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		int id = Integer.parseInt(request.getParameter("id"));
		String consegnaString = request.getParameter("ritiroEffettivo");
		LocalDate consegnaEffettiva = LocalDate.parse(consegnaString);
		Prenotazione prenotazione = prenotazioneDao.findById(id);
		prenotazione.setDataConsegnaEffettiva(consegnaEffettiva);
		prenotazioneDao.updatePrenotazione(prenotazione);
		List<Prenotazione> prenotazioni = prenotazioneDao.findAllPrenotazioni();
		request.setAttribute("prenotazioni", prenotazioni);
		request.getRequestDispatcher("WEB-INF/jsp/GestionePrenotazioni.jsp").forward(request, response);
	}

}
