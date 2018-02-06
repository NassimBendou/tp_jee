<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste de livres</title>
</head>
<body>
	<jsp:include page="inc/menu.jsp"/>
	<h1>Liste de livres</h1>	
	<h3>${msgResultat}</h3>
	<table>
		<tr>
			<th>Titre</th>
			<th>Auteur</th>
			<th>Année</th>
		</tr>
		<c:forEach items="${listeLivres}" var="livre" >
			<tr> 
				<td>${livre.titre }</td>
				<td>${livre.auteur }</td>
				<td>${livre.annee }</td>			
			</tr>
		</c:forEach>	
	</table>	
	
</body>
</html>