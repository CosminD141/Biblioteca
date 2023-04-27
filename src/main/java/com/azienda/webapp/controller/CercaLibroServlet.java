package com.azienda.webapp.controller;

import java.io.IOException;
import java.util.List;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Utente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/CercaLibro")
public class CercaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeGenere = request.getParameter("genere");
		List<Libro> libri = null;
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		HttpSession session = request.getSession();
		Utente u = (Utente)session.getAttribute("utente");
		if(u!=null) {
			if(nomeGenere!=null && !nomeGenere.isEmpty()) {
				libri = libroDao.findByGenere(nomeGenere.trim());
				request.setAttribute("libri", libri);
				request.setAttribute("nome", nomeGenere);
				request.getRequestDispatcher("WEB-INF/jsp/CercaLibro.jsp").forward(request, response);
			}else {
				response.sendRedirect("PersonalHomePage");
				
			}
		}else {
			response.sendRedirect("Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
