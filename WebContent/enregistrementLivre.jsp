<%@page import="base.Base"%>
<%@page import="bean.Livre"%>
<jsp:useBean id="livre" class="bean.Livre" scope="request"/>  
<jsp:setProperty property="*" name="livre" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
	if(request.getParameter("submit") !=null)
	{
	  	String titre=request.getParameter("titre");
	  	String auteur=request.getParameter("auteur");
	  	String anneeStr=request.getParameter("annee");
	  	String msgResultat="Echec d'enregistrement du livre";
	  	
	  	Integer annee= new Integer(0);
	  	try
	  	{
	  		annee=Integer.parseInt(anneeStr);	 
	  	}catch(Exception e)
	  	{
	  		e.printStackTrace();
	  	}
	  	
	  	boolean titreNonValide=titre.trim().equals("");
	  	boolean auteurNonValide=auteur.trim().equals("");
	  	boolean anneNonValide= anneeStr.length()<4 ;
	  	
	  	
	  	if(titreNonValide) request.setAttribute("msgTitre", "Veuillez remplir le champ \"titre\" ");
	  	if(auteurNonValide) request.setAttribute("msgAuteur", "Veuillez remplir le champ 'auteur' ");
	  	if(anneNonValide) request.setAttribute("msgAnnee","Veuillez remplir le champ 'année' , l'année doit contenir au moins 4 chiffres");
	  	
	 
	    
	  	
	  	if(!titreNonValide && !auteurNonValide && !anneNonValide && livre!=null)
	  	{		 	
		 	Base base=new Base();
		 	boolean co=base.ouvrir();	 
		 	base.enregistrerLivre(livre);
		 	base.fermer();	
		 	request.removeAttribute("livre");
		 	msgResultat="Enregistrement du livre avec succès";
	  	}
	  	request.setAttribute("msgResultat", msgResultat);
	}
 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enregistrement Livre</title>
</head>
<body>
	
	<h1>Enregistrement Livre</h1>
		<form method="post" action="">
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