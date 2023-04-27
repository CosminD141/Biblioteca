<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi libro</title>
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
 
 
 <section class="user_profile inner_pages">
	<div class="container">
		<div class="col-md-6 col-sm-8">
 			<div class="profile_wrap" style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-80px">
				<div class="gray-bg field-title">
              		<h3 style="text-align:center">Aggiungi nuovo libro</h3>
              	</div>
              	<form action="Aggiungilibro" method="POST" enctype="multipart/form-data">
             	 <div class="form-group">
             		 <label class="control-label">Autore</label>
              		 <input class="form-control white_bg" type="text" required name="autore">
            	</div>
            	<div class="form-group">
              		<label class="control-label">Titolo</label>
             	 	<input class="form-control white_bg" type="text" required name="titolo">
            	</div>
		       	<div class="form-group">
              		<label class="control-label">Anno pubblicazione</label>
             	 	<input class="form-control white_bg" type="text" required name="anno">
            	</div>
            	<div class="form-group">
              		<label class="control-label">Numero copie</label>
             	 	<input class="form-control white_bg" type="number" required name="copie">
            	</div>
	          	<div class="form-group">
              		<label class="control-label">Genere</label>
             	 	<select class="form-control mr-sm-2" name="genere">
						<option value="Giallo">Giallo</option>
						<option value="Horror">Horror</option>
						<option value="Azione">Azione</option>
						<option value="Rosa">Rosa</option>
						<option value="Fantasy">Fantasy</option>
						<option value="Biografia">Biografia</option>
						<option value="Thriller">Thriller</option>
						<option value="Libbroso">Libbroso</option>
					</select>
            	</div>
            	<div class="form-group">      
	  				<label for="formFile" class="form-label">Foto (opzionale)</label> 
	  				<input class="form-control" type="file" name="file">
				</div>
           
            <div class="py-1" style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-80px">
				<div class="btn-example">
             		<input type="submit" class="btn btn-outline-primary" value="Aggiungi">
            	</div>
            </div>
            </form>
          </div>
			<%
				Boolean flag = (Boolean)request.getAttribute("flag");
				if(flag!=null && flag){
		%>
				<p style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-80px; color:red">Aggiunta riuscita con successo !</p>
				<%
				}else if(flag!=null){
			%>
					<p style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-80px; color:red">Errore nell'aggiunta</p>
					<%	
					}
				%>
         </div>
      </div> 
  </section>
 
</body>
</html>