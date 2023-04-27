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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@jakarta.servlet.annotation.WebServlet("/CercaRuolo")
public class CercaRuoloServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		UtenteDao utenteDao = factory.getUtenteDao();
		Utente u = (Utente)request.getSession().getAttribute("admin");
		RuoloDao ruoloDao = factory.getRuoloDao();		
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
		
		List<Utente> utenti = utenteDao.findUtenteByRuolo(newRuolo);
		
		if(u!=null) {
			request.setAttribute("utentiByRuolo", utenti);
			request.getRequestDispatcher("WEB-INF/jsp/CercaRuolo.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
		
//		request.setAttribute("utentiByRuolo", utenti);
//		request.getRequestDispatcher("WEB-INF/jsp/CercaRuolo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
