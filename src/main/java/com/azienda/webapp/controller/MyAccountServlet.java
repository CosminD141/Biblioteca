package com.azienda.webapp.controller;

import java.io.IOException;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.UtenteDao;
import com.azienda.webapp.model.Utente;
import com.azienda.webapp.utilities.Utilities;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/MyAccount")
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DaoFactory factory = DaoFactory.getFactory("jpa");
		Utente u = (Utente)request.getSession().getAttribute("utente");
//		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
//		List<Prenotazione> prenotazioni = prenotazioneDao.findByUtente(u);
		if(u!=null) {
//			request.setAttribute("prenotazioni", prenotazioni);
			request.getRequestDispatcher("WEB-INF/jsp/MyAccount.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		UtenteDao utenteDao = factory.getUtenteDao();
		@SuppressWarnings("unused")
		String username = request.getParameter("username");
		String newUsername = request.getParameter("newUsername");
		String confirmUsername = request.getParameter("confirmUsername");
		int id = Integer.parseInt(request.getParameter("id")); 
		Utente u = utenteDao.findUtenteById(id);
		Boolean check = false;
		if(newUsername.equals(confirmUsername)) {
			check = Utilities.checkEmail(newUsername);
		}
		if(check) {
			u.setUsername(newUsername);
			utenteDao.updateUsername(u);
			request.setAttribute("esito", "Modifica effettuata con successo");
		}else {
			request.setAttribute("esito", "I dati inseriti non sono corretti");
		}
		request.getSession().setAttribute("utente", u);
		request.getRequestDispatcher("WEB-INF/jsp/MyAccount.jsp").forward(request, response);
	}

}
