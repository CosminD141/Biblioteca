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


@WebServlet("/EliminaLibro")
public class EliminaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		Utente u = (Utente)request.getSession().getAttribute("admin");
		List<Libro> libri = libroDao.findAll();
		if(u!=null) {
			request.setAttribute("listaLibri", libri);		
			request.getRequestDispatcher("WEB-INF/jsp/Libro.jsp").forward(request, response);
		}else {
			response.sendRedirect("Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*-------------------------------------------------------------------------------------------*/
//      LibroDao libroDao = LibroDaoImplJDBC.getInstance();
		DaoFactory factory = DaoFactory.getFactory();
		LibroDao libroDao = factory.getLibroDao();
		String idStringa = request.getParameter("id");
		int id = Integer.parseInt(idStringa);
		libroDao.remove(id); 
		response.sendRedirect("EliminaLibro");
		
	}

}
