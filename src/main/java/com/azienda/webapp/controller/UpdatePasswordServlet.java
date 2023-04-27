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

@WebServlet("/UpdatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		UtenteDao utenteDao = factory.getUtenteDao();
		
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		int id = Integer.parseInt(request.getParameter("id"));
		Utente u = utenteDao.findUtenteById(id);
		Boolean check = false;
		if(newPassword.equals(confirmPassword)) {
			check = Utilities.checkPassword(newPassword);
		}
		if(check) {
			u.setPassword(newPassword);
			utenteDao.updatePassword(u);
			request.setAttribute("esitoPassword", "Modifica effettuata con successo");
		}else {
			request.setAttribute("esitoPassword", "I dati inseriti non sono corretti");
		}
		request.getSession().setAttribute("utente", u);
		request.getRequestDispatcher("WEB-INF/jsp/MyAccount.jsp").forward(request, response);
	}

}
