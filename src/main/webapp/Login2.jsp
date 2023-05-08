<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
<%@ include file ="/WEB-INF/css/LoginStyle2.css"%>
</style>
</head>
<body>
	<div class="login-wrap">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
				for="tab-1" class="tab">Sign In</label> <input id="tab-2"
				type="radio" name="tab" class="sign-up"><label for="tab-2"
				class="tab">Sign Up</label>
			<div class="login-form">
				<div class="sign-in-htm">

					<form action="Login" method="POST">
						<div class="group">
							<label for="user" class="label">Username</label> <input id="user"
								type="text" class="input" name="username">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> <input id="pass"
								type="password" class="input" data-type="password"
								name="password">
						</div>

						<div class="group">
							<input id="check" type="checkbox" class="check" checked>
							<label for="check"><span class="icon"></span> Keep me Signed in</label>
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign In">
						</div>
					</form>
					<div class="hr"></div>
					  <% 
				String esito = (String)request.getAttribute("esito");
					if(esito!=null){
				%>
				<p style="position:relative; top:1%; left:50%; bottom: 50%; margin-top:30px; margin-left:-105px; color:red"><%=esito%></p>
			<%
				}	
			%>
				</div>
				<form action="Registrazione" method="POST">
					<div class="sign-up-htm">
						<div class="group">
							<label for="pass" class="label">Nome</label> 
							<input id="name" type="text" class="input" name="nome">
						</div>
						<div class="group">
							<label for="pass" class="label">Cognome</label> 
							<input id="surname" type="text" class="input" name="cognome">
						</div>
						<div class="group">
							<label for="user" class="label">Email</label> 
							<input id="user" type="text" class="input" name="username">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> 
							<input id="pass" type="password" class="input" data-type="password" name="password">
						</div>
						<div>
						
						La password deve contenere almeno 8 caratteri di cui: un carattere speciale, un numero ed una lettera maiuscola <br>
						
						</div>
						<br>
							<div class="group">
								<input type="submit" class="button" value="Sign Up">
							</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<label for="tab-1">Already Member?</label>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>