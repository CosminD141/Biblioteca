package com.azienda.webapp.controller;

import java.io.IOException;
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


@WebServlet("/DettagliPrenotazioni")
public class DettagliPrenotazioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DaoFactory factory = DaoFactory.getFactory();
		Utente u = (Utente)request.getSession().getAttribute("utente");
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		List<Prenotazione> prenotazioni = prenotazioneDao.findByUtente(u);
		if(u!=null) {
			request.setAttribute("prenotazioni", prenotazioni);
			request.getRequestDispatcher("WEB-INF/jsp/DettagliPrenotazioni.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
