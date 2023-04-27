<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.azienda.webapp.model.Libro" %>    
<%@ page import="com.azienda.webapp.model.Genere" %>
<%@ page import="com.azienda.webapp.model.Utente" %>
<%@ page import="java.util.List" %>   
<%@ page import="java.util.ArrayList" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Libro</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
<%
	Utente utente = (Utente)request.getSession().getAttribute("utente");
%>
<div class="bd-example">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    
	<ul class="navbar-nav mr-auto">
        <li class="nav-item active">  
    		<a class="nav-link"  href="#"><%=utente.getNome()%></a>
    	</li>
    </ul>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="true" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse show" id="navbarColor01" style="">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="http://localhost:8080/Biblioteca/PersonalHomePage?">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item active">
          <a class="nav-link"href="http://localhost:8080/Biblioteca/MyAccount?">MyAccount</a>
        </li>
    	<li class="nav-item active">
          <a class="nav-link" href="http://localhost:8080/Biblioteca/Preferiti?">Preferiti</a>
        </li>
      </ul>
      <form class="form-inline" action="CercaLibro" method="GET">
        <input class="form-control mr-sm-2" type="search" placeholder="Search genere" aria-label="Search" name="genere">
        <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
      </form>
       <form class="form-inline" action="Logout" method="GET">
        <input class="btn btn-outline-info my-2 my-sm-0" value="Logout" type="submit">
      </form>
    </div>
  </nav>
 </div>
 </header>
 <%
	Libro libro = (Libro)request.getAttribute("libro");
	String prenotazione = (String)request.getAttribute("prenotazione");
	if(libro!=null){
 %>
 	<table  class="table table-hover">
		<tr>
			<th align="center"><b>Id</b></th>
			<th align="center"><b>Autore</b></th>
			<th align="center"><b>Titolo</b></th>
			<th align="center"><b>Anno Pubblicazione</b></th>
			<%
				List<Genere> generi = libro.getGenere();
				for(int i = 0; i<generi.size(); i++){
			%>
		
				<th align="center"><b>Genere Libro</b></th>
		
				<%
				}
				%>
			<th align="center"><b>N° copie</b></th> 
			<th align="center"><b>Prenota</b>
			</tr>
			<tr>
				<td><%=libro.getId()%></td> 
				<td><%=libro.getAutore()%></td>
				<td><%=libro.getTitolo()%></td>
				<td><%=libro.getAnnoPubblicazione()%></td>
				<%
					for(int i = 0; i < generi.size(); i++){
				%>
		
					<td><%=generi.get(i).getNome()%></td>
		
					<%
					}
				%>
				<td><%=libro.getNumeroCopie()%></td>
				<td>
				<form action="Prenotazione" method="GET">
				<input type="hidden" name="id" value="<%=libro.getId()%>">
				<%
					if(libro.getNumeroCopie()==0){
				%>
						<button type="submit" style="border:0; background-color: transparent" disabled>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bookmark-check" viewBox="0 0 16 16">
			  				<path fill-rule="evenodd" d="M10.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
			  				<path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
						</svg>
					</button>
				<%
					}else{
				%>
				<button type="submit" style="border:0; background-color: transparent">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bookmark-check" viewBox="0 0 16 16">
		  				<path fill-rule="evenodd" d="M10.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
		  				<path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
					</svg>
				</button>
				<%
					}
					
				%>		
				</form>
				</td>
			</tr>
		</table>
		<%
			if(prenotazione!=null){
			%>
				<p><%=prenotazione%></p>
					
					<%
				}	
 			}if(libro.getFoto()!=null){
		 %>
		 <div class="text-center">
  			<img src="res/<%=libro.getFoto()%>" class="rounded" alt="..." />
		</div>
		 <%
 			}
		 %>
</body>
</html>