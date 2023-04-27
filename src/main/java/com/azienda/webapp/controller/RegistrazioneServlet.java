package com.azienda.webapp.controller;

import java.io.IOException;
import com.azienda.webapp.dao.concreteClass.RuoloDaoImplJPA;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.UtenteDao;
import com.azienda.webapp.model.Ruolo;
import com.azienda.webapp.model.Utente;
import com.azienda.webapp.utilities.Constants;
import com.azienda.webapp.utilities.Utilities;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Registrazione")
public class RegistrazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean controllo = Utilities.checkNomeCognome(nome) && Utilities.checkNomeCognome(cognome) && Utilities.checkEmail(username) &&
				Utilities.checkPassword(password);
		if(nome!=null && !nome.isEmpty() && cognome!=null && !cognome.isEmpty() && username!=null && !username.isEmpty() &&
				password!=null && !password.isEmpty() && controllo) {
				DaoFactory factory = DaoFactory.getFactory();
				UtenteDao utenteDao = factory.getUtenteDao();
				Ruolo ruolo = RuoloDaoImplJPA.getInstance().findRuoloByName(Constants.RUOLO_USER);
				Utente u = new Utente(nome, cognome, username, password, ruolo);
				utenteDao.save(u);
				response.sendRedirect("Login");
				
		}else {
			request.setAttribute("errore", "dati inseriti non validi");
			request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
		}
		
	}

}
