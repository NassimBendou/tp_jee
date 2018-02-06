package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Base;
import bean.Livre;

/**
 * Servlet implementation class EnregistrementLivre
 */
@WebServlet("/enregistrementLivre")
public class EnregistrementLivre extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private final String VUE_CONNECTER="/connecter.jsp";
	private final String VUE_ENREG_LIVRE="/WEB-INF/enregistrementLivre.jsp";
	private final String VUE_LISTE_LIVRES_REDIRECT="listeLivres";
	private final String VUE_LISTE_LIVRES_FORWARD="/listeLivres";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrementLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		Boolean isLogged=false;
		try
		{
			isLogged=Boolean.valueOf(session.getAttribute("isLogged").toString());	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		System.out.println("valeur : "+isLogged);
		if( isLogged==true)
			this.getServletContext().getRequestDispatcher(VUE_ENREG_LIVRE).forward(request, response);
		else 
			response.sendRedirect("connecter");
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
	  	
	 
	    Livre livre=new Livre();
		livre.setTitre(titre);
		livre.setAnnee(annee);
		livre.setAuteur(auteur);
	  	
	  	if(!titreNonValide && !auteurNonValide && !anneNonValide && livre!=null)
	  	{		 	
		 	Base base=new Base();
		 	boolean co=base.ouvrir();	 
		 	base.enregistrerLivre(livre);
		 	base.fermer();	
		 	request.removeAttribute("livre");
		 	msgResultat="Enregistrement du livre :\" "+livre.getTitre()+" \" avec succès";
		 	request.setAttribute("msgResultat", msgResultat);
		 	
		 	
		 	this.getServletContext().getRequestDispatcher(VUE_LISTE_LIVRES_FORWARD).forward(request, response);
		 	response.sendRedirect(VUE_LISTE_LIVRES_REDIRECT);
	  	}
	  	else
	  	{
	  		request.setAttribute("msgResultat", msgResultat);
	  		this.getServletContext().getRequestDispatcher(VUE_ENREG_LIVRE).forward(request, response);
	  	}
	  	
	}
	 
	

}
