package com.azienda.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.azienda.webapp.dao.concreteClass.LibroDaoImplJPA;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.UtenteDao;
import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Utente;
import com.azienda.webapp.utilities.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		DaoFactory factory = DaoFactory.getFactory();
		UtenteDao utenteDao = factory.getUtenteDao();
		boolean checkDate = utenteDao.findByUsernameAndPassword(username, password);
		
		if(checkDate) {
			Utente utente = utenteDao.findUtenteByUsername(username);
			Utente u = utenteDao.findRuoloByUsername(username);
			List<Libro> libri = new ArrayList<Libro>();
			if(u.getRuolo().getDescrizione().equalsIgnoreCase(Constants.RUOLO_ADMIN)) {
				//PAGINA ADMIN CON LISTA UTENTI
				//PASSO LISTA UTENTI
				List<Utente> utenti = utenteDao.findAll();
				request.getSession().setAttribute("admin", utente);
				request.setAttribute("utenti", utenti);
				request.getRequestDispatcher("WEB-INF/jsp/AdminHomePage.jsp").forward(request, response); 
			}else {
				//PAGINA STAFF E USER CON LISTA LIBRI SENZA POTER MODIFICARE NE AGGIUNGERE
				//PASSO LISTA LIBRI
				// utente.setPassword(null) protteggo la password
				request.getSession().setAttribute("utente", utente);
				libri = LibroDaoImplJPA.getInstance().findAll();
			}
			
//			request.setAttribute("idPrefe", 0);
			
			request.setAttribute("listaLibri", libri);
			request.getRequestDispatcher("WEB-INF/jsp/PersonalHomePage.jsp").forward(request, response);
		}else {
			request.setAttribute("esito", "dati non validi");
			request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
		}					
	}
}