<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<h3>Menu</h3>
	<ul>
		<li><a href="enregistrementLivre" >Enregistrer un livre</a></li>
		<li><a href="listeLivres" >liste de livres</a></li>
		${isLogged? "<li><a href=\"deconnecter\">Se deconnecter</a></li>" : "<li><a href=\"connecter\" >Se connecter</a></li>"  }
	</ul>
	
</body>
</html>