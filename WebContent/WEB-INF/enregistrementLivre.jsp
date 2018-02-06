<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrement Livre</title>
</head>
<body>
	<jsp:include page="../inc/menu.jsp" />
	<h1>Enregistrement Livre</h1>
		<form method="post" action="enregistrementLivre">
		<table>
		<tr>
			<td>Titre : </td>
			<td><input name="titre" type="text" value="${livre.titre}" /></td>
			<td>${msgTitre}</td>			
		</tr>
		<tr>
			<td>Auteur : </td>
			<td><input name="auteur" type="text" value="${livre.auteur}" /></td>
			<td> ${msgAuteur}</td>
		</tr>
		<tr>
			<td>Année : </td>
			<td><input name="annee" type="text" value="${livre.annee}"/></td>
			<td>${msgAnnee}</td> <!-- accéder à l'attribut mesAnne -->
		</tr>
		<tr>
			<td>&nbsp;</td>		
			<td><input name="submit" type="submit" value="Enregistrer" ></td>		
		</tr>
		<tr>
			<td>&nbsp;</td>		
			<td>${msgResultat}</td>		
		</tr>
		</table>
	</form>
</body>
</html>