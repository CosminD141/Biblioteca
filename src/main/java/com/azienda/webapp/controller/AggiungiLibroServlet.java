package com.azienda.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.azienda.webapp.dao.factory.DaoFactory;
import com.azienda.webapp.dao.interfaces.GenereDao;
import com.azienda.webapp.dao.interfaces.LibroDao;
import com.azienda.webapp.model.Genere;
import com.azienda.webapp.model.Libro;
import com.azienda.webapp.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Aggiungilibro")
@MultipartConfig
public class AggiungiLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente u = (Utente) request.getSession().getAttribute("admin");
		if (u != null) {
			request.getRequestDispatcher("WEB-INF/jsp/AggiungiLibro.jsp").forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String autore = request.getParameter("autore");
		String titolo = request.getParameter("titolo");
		String anno = request.getParameter("anno");
		String nome = request.getParameter("genere"); 
		int copie = Integer.parseInt(request.getParameter("copie"));
		String nomeGenere = "";
		switch(request.getParameter("genere")) {
			case "Giallo":
				nomeGenere = "giallo";
				break;
			case "Horror":
				nomeGenere = "horror";
				break;
			case "Azione":
				nomeGenere = "azione";
				break;
			case "Rosa":
				nomeGenere = "rosa";
				break;
			case "Fantasy":
				nomeGenere = "fantasy";
				break;
			case "Biografia":
				nomeGenere = "biografia";
				break;
			case "Thriller":
				nomeGenere = "thriller";
				break;
			case "Libbroso":
				nomeGenere = "Libbroso";
				break;			
		}
		boolean flag = true;
		
		
		if(autore!=null && !autore.isEmpty() && titolo != null && !titolo.isEmpty() && anno!=null && !titolo.isEmpty()
				&& nome!=null && !nome.isEmpty()) {
			
				DaoFactory factory = DaoFactory.getFactory();
				LibroDao libroDao = factory.getLibroDao();
				GenereDao genereDao = factory.getGenereDao();
				Genere genere = genereDao.findGenereByDescrizione(nomeGenere);
				List<Genere> generi = new ArrayList<Genere>();
				generi.add(genere);
				Libro libro = null;
					libro = new Libro(autore, titolo, anno, copie, generi);
				flag = libroDao.save(libro);
		}
		request.setAttribute("flag", flag);
		request.getRequestDispatcher("WEB-INF/jsp/AggiungiLibro.jsp").forward(request, response);
		
	}

}
