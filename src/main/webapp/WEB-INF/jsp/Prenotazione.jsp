<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.azienda.webapp.model.Libro" %>    
<%@ page import="com.azienda.webapp.model.Genere" %>
<%@ page import="com.azienda.webapp.model.Utente" %>
<%@ page import="java.util.List" %>   
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prenotazione</title>
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
	String prenotazione = (String)request.getAttribute("esito");
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
			<!-- <th align="center"><b>Prenota</b></th> -->
			<th align="center"><b>Data ritiro</b></th>
			<th align="center"><b>Conferma</b></th>
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
					<form action="Prenotazione" method="POST">
						<td><input type="date" name="dataRitiro" min="<%=LocalDate.now()%>" required></td>
						<td><input type="hidden" name="id" value="<%=libro.getId()%>">
							<button type="submit" style="border:0; background-color: transparent">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
								 	<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
							 		<path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
								</svg>
							</button>
						</td>
					</form>
			</tr>
		</table>
		<%
		if(prenotazione!=null){
			%>
			
			<div class="alert alert-success" role="alert">
  				<%=prenotazione%><b>successo</b>.
			</div>
			<%
		}
		
					}
					
				%>	
</body>
</html>