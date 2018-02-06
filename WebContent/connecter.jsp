<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de connexion</title>
</head>
<body>
	<form method="post" action="connecter">
		<h1>S'authentifier</h1>
		<table>
			<tr>
				<td><label>Login</label></td>
				<td><input type="text" name="login" value=""></td>
			</tr>
			<tr>
				<td><label>Mot de passe</label></td>
				<td><input type="password" name="passwd" value=""></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"  name="submit" value="Se connecter"></td>				
			</tr>
			<tr>	
				<td></td>		
				<td>${empty param.submit?"":"Erreur d'authentification"}</td>
			</tr>
			
		</table>	
	
	</form>

</body>
</html>