package com.azienda.webapp.controller;

import java.io.IOException;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AggiornaLibro")
@MultipartConfig
public class AggiornaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		Libro libro = libroDao.findById(Integer.parseInt(request.getParameter("id")));
		Utente u = (Utente)request.getSession().getAttribute("admin");
		if(u!=null) {
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("WEB-INF/jsp/AggiornaLibro.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		int numCopie = Integer.parseInt(request.getParameter("copie"));
		int idLibro = Integer.parseInt(request.getParameter("id"));
		Libro libro = libroDao.findById(idLibro);
		libro.setNumeroCopie(numCopie);
		libroDao.updateNumeroCopie(libro);
		request.setAttribute("update", "Salvataggio completato con ");
		request.setAttribute("libro", libro);
		request.getRequestDispatcher("WEB-INF/jsp/AggiornaLibro.jsp").forward(request, response);
	}

}
