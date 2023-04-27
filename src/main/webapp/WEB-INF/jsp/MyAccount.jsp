<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ page import ="com.azienda.webapp.model.Utente" %>
<%@ page import="java.util.List" %>
<%@ page import="com.azienda.webapp.model.Prenotazione" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
<%
	Utente utente = (Utente)session.getAttribute("utente");
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

int id = utente.getId();

%>

<section class="user_profile inner_pages">
  <div class="container">
<div class="col-md-6 col-sm-8">
 <div class="profile_wrap" style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-80px">
          <h5 class="uppercase underline">Il mio account</h5>
          
            <div class="form-group"> 
           
             <label class="control-label">Nome</label>
              <input class="form-control gray_bg" type="text" name="nome" value="<%=utente.getNome()%>" disabled>
          	</div>
            <div class="form-group">
              <label class="control-label">Cognome</label>
              <input class="form-control gray_bg" type="email" name="cognome" value="<%=utente.getCognome()%>" disabled>
         </div> 
         	<div class="form-group">    
               <label class="control-label">Username</label>
              <input class="form-control gray_bg" type="text" name="" value="<%=utente.getUsername()%>" disabled>
          	</div>
            <div class="form-group">
              <label class="control-label">Password</label>
              <input class="form-control gray_bg" type="email" name="" value="<%=utente.getPassword()%>" disabled>
            </div> 
            <form action="DettagliPrenotazioni" method="GET">
            <div class="form-group">
                <input class="btn btn-outline-info my-2 my-sm-0" type="submit" value="Dettagli prenotazioni">
            </div>
            </form>
          	<%
          		String esito = (String)request.getAttribute("esito");
          		String esitoPassword = (String)request.getAttribute("esitoPassword");
          	%>
            
          
            
            <div class="gray-bg field-title">
              <h6>Cambia Username</h6>
            </div>
            <form action="MyAccount" method="POST">
            <div class="form-group">
              <label class="control-label">Username</label>
              <input class="form-control gray_bg" type="text" name="username" value="<%=utente.getUsername()%>" disabled>
            </div>
            <div class="form-group">
              <label class="control-label">Inserisci nuovo Username</label>
              <input class="form-control white_bg" type="text" name="newUsername">
            </div>
             <div class="form-group">
              <label class="control-label">Conferma nuovo Username</label>
              <input class="form-control white_bg" type="text" name="confirmUsername">
            </div>
            <div class="form-group">
            	<input type="hidden" value="<%=id%>" name="id">
              <input class="btn btn-outline-info my-2 my-sm-0" type="submit" value="Salva">
            </div>
            <%
            	if(esito!=null){
            %>
            		
            		<p><%=esito%></p>
            	<%		
            	}
            %>
            
            </form>
            <div class="gray-bg field-title">
              <h6>Cambia password</h6>
            </div>
            <form action="UpdatePassword" method="POST">
            <div class="form-group">
              <label class="control-label">Password</label>
              <input class="form-control gray_bg" type="password" value="<%=utente.getPassword()%>" name="password" disabled>
            </div>
            <div class="form-group">
              <label class="control-label">Inserisci nuova Password</label>
              <input class="form-control white_bg" type="password" name="newPassword">
            </div>
            <div class="form-group">
              <label class="control-label">Conferma nuova Password</label>
              <input class="form-control white_bg" type="password" name="confirmPassword">
            </div>            
            <div class="form-group">
            	<input type="hidden" value="<%=id%>" name="id">
              <input class="btn btn-outline-info my-2 my-sm-0" type="submit" value="Salva">
            </div>
             <%
            	if(esitoPassword!=null){
            %>
            		
            		<p><%=esitoPassword%></p>
            	<%		
            	}
            %>
          </form>
        </div>
		</div>
		</div>
		
		</section>
</body>
</html>