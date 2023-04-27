<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.azienda.webapp.model.Libro" %>
<%@ page import ="com.azienda.webapp.model.Genere" %>
<%@ page import ="com.azienda.webapp.model.Utente" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cerca</title>
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
 String nomeGenere = (String)request.getAttribute("nome");
 List<Libro> libri = (List<Libro>)request.getAttribute("libri");
 if(libri!=null){
 %>
 <h3>Genere selezionato: <%=nomeGenere%></h3>
 <table  class="table table-hover">
	<tr>
		<th align="center"><b>Autore</b></th>
		<th align="center"><b>Titolo</b></th>
		<th align="center"><b>Anno Pubblicazione</b></th>
		<!-- <th align="center"><b>Genere</b></th> -->
	</tr>
<%
for(Libro libro : libri){
	
%>	
	<tr>
		<td><%=libro.getAutore()%></td>
		<td><%=libro.getTitolo()%></td>
		<td><%=libro.getAnnoPubblicazione()%></td>
		<%-- <td><%=nome%></td> --%>
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