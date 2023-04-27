<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.azienda.webapp.model.Libro" %>
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
	Libro libro = (Libro)request.getAttribute("libro");
	String update = (String)request.getAttribute("update");
%>
 <section class="user_profile inner_pages">
  	<div class="container">
  		<div class="row">
  	  		<%
  				if(libro.getFoto()!=null){
  			%>
  	           		<div class="col-4" style="margin-left: -100px; margin-top:10px">
  						<img src="res/<%=libro.getFoto()%>" class="rounded" alt="..." />
					</div>
					<div class="col-md-6 col-sm-8" style="margin-top:10px">
					<%
  					}else{
					%>
						<div class="col-md-6 col-sm-8" style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-300px">
					<%
  					}
					%>
 					<div class="profile_wrap" >
           				 <div class="form-group">
             				 <label class="control-label">Titolo</label>
             				 <input class="form-control gray_bg" type="text" name="titolo" value="<%=libro.getTitolo()%>" disabled>
            			</div>
	           			 <div class="form-group">
					              <label class="control-label">Autore</label>
					              <input class="form-control gray_bg" type="text" name="autore" value="<%=libro.getAutore()%>" disabled>
	            		</div>
	             		<div class="form-group">
					              <label class="control-label">Genere</label>
					              <input class="form-control gray_bg" type="text" name="genere" value="<%=libro.getGenere()%>" disabled>
	            		</div>
			            <div class="form-group">
					              <label class="control-label">Anno Pubblicazione</label>
					              <input class="form-control gray_bg" type="text" name="Anno" value="<%=libro.getAnnoPubblicazione()%>" disabled>
			            </div>
	             		
	            		<form action="AggiornaLibro" method="POST" enctype="multipart/form-data">
	            			<div class="form-group">
					              <label class="control-label">N° copie</label>
					              <input class="form-control gray_bg" type="number" name="copie" value="<%=libro.getNumeroCopie()%>" >
	            			</div>
	            			<div class="form-group">      
				  				<label for="formFile" class="form-label">Foto</label> 
				  				<input class="form-control" type="file" name="file">
							</div>
							<div class="form-group">
            					<input type="hidden" value="<%=libro.getId()%>" name="id">
              					<input class="btn btn-outline-info my-2 my-sm-0" type="submit" value="Salva">
            				</div>
						</form>
					 </div>	
 				</div>
 			</div>
 		</div>
 	</div>
</section>	
 <%
	if(update!=null){
	%>	
		<div class="alert alert-success" role="alert">
  			<%=update%><b>successo</b>.
		</div>
		<%
	}
%>
 

</body>
</html>