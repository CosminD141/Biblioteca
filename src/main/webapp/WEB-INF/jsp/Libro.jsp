<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import ="com.azienda.webapp.model.Libro" %>
<%@ page import ="com.azienda.webapp.model.Genere" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libro</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
<div class="bd-example">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="true" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse show" id="navbarColor01" style="">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="http://localhost:8080/Biblioteca/AdminHomePage?">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/Biblioteca/Aggiungilibro?">Aggiungi</a>
        </li>
        <li class="nav-item">
          <a class="nav-link"href="http://localhost:8080/Biblioteca/EliminaLibro?">Libri</a>
        </li>
        <li class="nav-item">
          <a class="nav-link"href="http://localhost:8080/Biblioteca/GestionePrenotazioni?">Prenotazioni</a>
        </li>
      </ul>
      <form class="form-inline" action="CercaRuolo" method="GET">
        		<select class="form-control mr-sm-2" name="ruolo">
					<option value="User">User</option>
					<option value="Staff">Staff</option>
					<option value="Admin">Admin</option>
				</select>
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
	List<Libro> libri = (List<Libro>)request.getAttribute("listaLibri");
	if(libri!=null){	 
%> 
		<table  class="table table-hover">
			<tr>
				<th align="center"><b>Id</b></th>
				<th align="center"><b>Autore</b></th>
				<th align="center"><b>Titolo</b></th>
				<th align="center"><b>Anno Pubblicazione</b></th>
				<!-- <th align="center"><b>Genere</b></th>  -->
				<th align="center"><b>Elimina</b></th>
				<th align="center" class="col-1"><b>Aggiorna</b></th>
			</tr>
			<%
				for(Libro libro : libri){
					int id = libro.getId(); 
					String autore = libro.getAutore();
					String titolo = libro.getTitolo();
				 	String annoPubblicazione = libro.getAnnoPubblicazione();
				/* 	Genere genere = new Genere(libro.getGenere().getNome());  */
 		%> 
					<tr>
						<td><%=id%></td> 
						<td><%=autore%></td>
						<td><%=titolo%></td>
						<td><%=annoPubblicazione%></td>
						<td>
							<form action="EliminaLibro" method="POST">
								<input type="hidden" value="<%=id%>" name="id">
								<button type="submit" style="border:0; background-color: transparent">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
										  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
										  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
									</svg>
								</button>
							</form>
						</td> 
						<td>
							<form action="AggiornaLibro" method="GET">
								<input type="hidden" value="<%=id%>" name="id">
								<button type="submit" style="border:0; background-color: transparent">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
  										<path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
									</svg>
								</button>
							</form>
						</td> 
						
					</tr>
				<%
					}
			%>
		</table> 
		<%	
			}
	%>
</body>
</html>