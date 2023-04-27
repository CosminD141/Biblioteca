package com.azienda.webapp.controller;

import java.io.IOException;
import java.util.List;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.RuoloDao;
import com.azienda.webapp.dao.interfaces.UtenteDao;
import com.azienda.webapp.model.Ruolo;
import com.azienda.webapp.model.Utente;
import com.azienda.webapp.utilities.Constants;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/UpdateRuolo")
public class UpdateRuoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		UtenteDao utenteDao = factory.getUtenteDao();
		RuoloDao ruoloDao = factory.getRuoloDao();
		String idStringa = request.getParameter("id");
		int id = Integer.parseInt(idStringa);
		Utente utente = utenteDao.findUtenteById(id);
		String ruolo = "";
		switch(request.getParameter("ruolo")) {
			case "User":
				ruolo = Constants.RUOLO_USER;
				break;
			case "Staff":
				ruolo = Constants.RUOLO_STAFF;
				break;
			case "Admin":
				ruolo = Constants.RUOLO_ADMIN;
				break;
		}
		Ruolo newRuolo = ruoloDao.findRuoloByName(ruolo);
		utente.setRuolo(newRuolo);
		utenteDao.updateRuoloUtente(utente);
		List<Utente> utenti = utenteDao.findAll();
		request.setAttribute("utenti", utenti);
		request.getRequestDispatcher("WEB-INF/jsp/AdminHomePage.jsp").forward(request, response);
	}

}
