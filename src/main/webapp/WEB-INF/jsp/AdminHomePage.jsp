<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>     
<%@ page import="com.azienda.webapp.model.Utente" %>
<%@ page import="com.azienda.webapp.model.Ruolo" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Business HomePage</title>
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
List<Utente> utenti = (List<Utente>) request.getAttribute("utenti");
if(utenti!=null){
%> 
	<table  class="table table-hover">
		<tr>
			<th align="center"><b>Id</b></th>
			<th align="center"><b>Nome</b></th>
			<th align="center"><b>Cognome</b></th>
			<th align="center"><b>Email</b></th>
			<th align="center"><b>Ruolo</b></th>
			<th align="center"><b>Modifica</b></th> 
		</tr>
		<%
		for(Utente utente : utenti){
			int id = utente.getId(); 
			String nome = utente.getNome();
			String cognome = utente.getCognome();
		 	String username = utente.getUsername();
			Ruolo ruolo = new Ruolo(utente.getRuolo().getDescrizione());  
	 	%>
		<tr>
			<td><%=id%></td> 
			<td><%=nome%></td>
			<td><%=cognome%></td>
			<td><%=username%></td>
			<td><%=ruolo%></td>  
			<td>
				<form action="UpdateRuolo" method="POST">
					<select name="ruolo">
					<option value="User">User</option>
					<option value="Staff">Staff</option>
					<option value="Admin">Admin</option>
					</select>
					<input type="hidden" value="<%=id%>" name="id">   
					<input type="submit" value="V" style=color:Green;>
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