<%@page import="base.Base"%>
<%@page import="bean.Livre"%>

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
	  	
	  	Livre livre= new Livre();
	 	livre.setTitre(titre);
	 	livre.setAuteur(auteur);
	 	livre.setAnnee(annee);
	  	request.setAttribute("livre", livre);	  
	  	
	  	if(!titreNonValide && !auteurNonValide && !anneNonValide)
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
			<td><input name="titre" type="text" value="<% if(request.getAttribute("livre")!=null) out.print(((Livre)request.getAttribute("livre")).getTitre()); %>" /></td>
			<td><%if(request.getAttribute("msgTitre")!=null) out.println(request.getAttribute("msgTitre").toString()); %></td>			
		</tr>
		<tr>
			<td>Auteur : </td>
			<td><input name="auteur" type="text" value="<% if(request.getAttribute("livre")!=null) out.print(((Livre)request.getAttribute("livre")).getAuteur()); %>"/></td>
			<td> <% if(request.getAttribute("msgAuteur") !=null)  out.println(request.getAttribute("msgAuteur").toString()); %></td>
		</tr>
		<tr>
			<td>Année : </td>
			<td><input name="annee" type="text" value="<% if(request.getAttribute("livre")!=null) out.print(((Livre)request.getAttribute("livre")).getAnnee()); %>"/></td>
			<td><% if(request.getAttribute("msgAnnee") !=null)  out.println(request.getAttribute("msgAnnee").toString()); %></td>
		</tr>
		<tr>
			<td>&nbsp;</td>		
			<td><input name="submit" type="submit" value="Enregistrer" ></td>		
		</tr>
		<tr>
			<td>&nbsp;</td>		
			<td><% if(request.getAttribute("msgResultat")!=null) out.print(request.getAttribute("msgResultat")); %></td>		
		</tr>
		</table>
	</form>
</body>
</html>