<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.azienda.webapp.model.Prenotazione" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	List<Prenotazione> prenotazioni = (List<Prenotazione>)request.getAttribute("prenotazioni");
		if(prenotazioni!=null){
		%>
			<table  class="table table-hover">
				<tr>
					<th align="center"><b>Id</b></th>
					<th align="center"><b>Codice Utente</b></th>
					<th align="center"><b>Titolo Libro</b></th>
					<th align="center"><b>Data prenotazione</b></th>
					<th align="center"><b>Data consegna</b></th>
					<th align="center"><b>Consegna effettiva</b></th>
					<!-- <th align="center"><b>Conferma</b></th> -->
				</tr>
		<%
			for(Prenotazione p : prenotazioni){
%>

				<tr>
					<td><%=p.getId()%></td> 
					<td><%=p.getUtente().getId()%></td>
					<td><%=p.getLibro().getTitolo()%></td>
					<td><%=p.getDataOdierna()%></td>
					<td><%=p.getDataConsegna()%></td>
					<%
					if(p.getDataConsegnaEffettiva()!=null){
					%>
					<td>
						<input type = "date"  name="ritiroEffettivo" value="<%=p.getDataConsegnaEffettiva()%>" disabled>
						<button type="submit" style="border:0; background-color: transparent" disabled>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
							  	<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
							  	<path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
							</svg>
						</button>					
					</td>
					<%
					}else{
					%>
					
					<td>
						<form action="GestionePrenotazioni" method="POST">
							<input type="hidden" name="id" value="<%=p.getId()%>">
							<input type = "date"  name="ritiroEffettivo" max="<%=LocalDate.now()%>" required>
							<button type="submit" style="border:0; background-color: transparent">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
							  		<path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
							  		<path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
								</svg>
							</button>
						</form>			
					</td>
					<%
					}
					%>
				</tr>

<%
			}//Chiusura for
			%>
			</table>
			<%
		}//Chiusura if
%>

</body>
</html>