<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>


<section class="user_profile inner_pages">
	<div class="container">
		<div class="col-md-6 col-sm-8">
 			<div class="profile_wrap" style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-80px">
				<div class="gray-bg field-title">
              		<h3 style="text-align:center">Login</h3>
              	</div>
 
              	<form action="Login" method="POST" >
             	 <div class="form-group">
             		 <label class="control-label">Username</label>
              		 <input class="form-control white_bg" type="email" name="username">
            	</div>
            	<div class="form-group">
              		<label class="control-label">Password</label>
             	 	<input class="form-control white_bg" type="password" name="password">
            	</div>
            </div>
            <div class="py-1" style="position:relative; top:50%; left:50%; margin-top:10px; margin-left:-80px">
				<div class="btn-example" style=" float:left; margin-left:5px">
             		<input type="submit" class="btn btn-outline-primary" value="Login">
            	</div>
            	</form>
            	<form action="Registrazione" method="GET">
            		<div class="btn-example" style=" float:left; margin-left:5px">
             		<input type="submit" class="btn btn-outline-primary" value="Registrati">
            	</div>
            	</form>
            
            </div>

            <% 
				String esito = (String)request.getAttribute("esito");
					if(esito!=null){
				%>
				<p style="position:relative; top:1%; left:50%; bottom: 50%; margin-top:60px; margin-left:-80px; color:red"><%=esito%></p>
			<%
				}	
			%>
         </div>
      </div> 
  </section>

</body>
</html>