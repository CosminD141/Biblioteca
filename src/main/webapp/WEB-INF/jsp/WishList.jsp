<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.azienda.webapp.model.Libro" %>
<%@ page import = "com.azienda.webapp.model.Genere" %>
<%@ page import = "java.util.List" %>
<%@ page import ="com.azienda.webapp.model.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WishList</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

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
List<Libro> libri = (List<Libro>)request.getAttribute("preferiti");
if(libri!=null){
	%>
	<table  class="table table-hover">
		<tr>
			<th align="center"><b>Id</b></th>
			<th align="center"><b>Autore</b></th>
			<th align="center"><b>Titolo</b></th>
			<th align="center"><b>Anno Pubblicazione</b></th>
			<th align="center">Generi</th>
			<th align="center"><b>N° copie</b></th> 
			<th align="center"><b>Dislike</b></th> 
			<th align="center"><b>Prenota</b>
		</tr>
		<%	
		for(Libro l : libri){
	%>				
		<tr>
			<td><%=l.getId()%></td> 
			<td><%=l.getAutore()%></td>
			<td><%=l.getTitolo()%></td>
			<td><%=l.getAnnoPubblicazione()%></td>
			<td><%=l.getGeneriNomi()%></td>
			<td><%=l.getNumeroCopie()%></td>
			<td>
				<form action="Preferiti" method="POST">
					<input type="hidden" name="id" value="<%=l.getId()%>">
					<button type="submit" style="border:0; background-color: transparent">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-hand-thumbs-down" viewBox="0 0 16 16">
						 	 <path d="M8.864 15.674c-.956.24-1.843-.484-1.908-1.42-.072-1.05-.23-2.015-.428-2.59-.125-.36-.479-1.012-1.04-1.638-.557-.624-1.282-1.179-2.131-1.41C2.685 8.432 2 7.85 2 7V3c0-.845.682-1.464 1.448-1.546 1.07-.113 1.564-.415 2.068-.723l.048-.029c.272-.166.578-.349.97-.484C6.931.08 7.395 0 8 0h3.5c.937 0 1.599.478 1.934 1.064.164.287.254.607.254.913 0 .152-.023.312-.077.464.201.262.38.577.488.9.11.33.172.762.004 1.15.069.13.12.268.159.403.077.27.113.567.113.856 0 .289-.036.586-.113.856-.035.12-.08.244-.138.363.394.571.418 1.2.234 1.733-.206.592-.682 1.1-1.2 1.272-.847.283-1.803.276-2.516.211a9.877 9.877 0 0 1-.443-.05 9.364 9.364 0 0 1-.062 4.51c-.138.508-.55.848-1.012.964l-.261.065zM11.5 1H8c-.51 0-.863.068-1.14.163-.281.097-.506.229-.776.393l-.04.025c-.555.338-1.198.73-2.49.868-.333.035-.554.29-.554.55V7c0 .255.226.543.62.65 1.095.3 1.977.997 2.614 1.709.635.71 1.064 1.475 1.238 1.977.243.7.407 1.768.482 2.85.025.362.36.595.667.518l.262-.065c.16-.04.258-.144.288-.255a8.34 8.34 0 0 0-.145-4.726.5.5 0 0 1 .595-.643h.003l.014.004.058.013a8.912 8.912 0 0 0 1.036.157c.663.06 1.457.054 2.11-.163.175-.059.45-.301.57-.651.107-.308.087-.67-.266-1.021L12.793 7l.353-.354c.043-.042.105-.14.154-.315.048-.167.075-.37.075-.581 0-.211-.027-.414-.075-.581-.05-.174-.111-.273-.154-.315l-.353-.354.353-.354c.047-.047.109-.176.005-.488a2.224 2.224 0 0 0-.505-.804l-.353-.354.353-.354c.006-.005.041-.05.041-.17a.866.866 0 0 0-.121-.415C12.4 1.272 12.063 1 11.5 1z"/>
						</svg>
					</button>
				</form>
			</td>
			<td>
				<form action="Prenotazione" method="GET">
				<input type="hidden" name="id" value="<%=l.getId()%>">
				<%
					if(l.getNumeroCopie()==0){
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
			<%
		}
		%>
	</table>
	<%
	}
%>

</body>
</html>