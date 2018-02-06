package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Base;
import bean.Livre;

/**
 * Servlet implementation class ListeLivres
 */
@WebServlet("/listeLivres")
public class ListeLivres extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public static final String VUE ="/listeLivres.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeLivres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Base base= new Base();
		base.ouvrir();		
		List<Livre> listeLivres=base.listerLivres();
		base.fermer();
		request.setAttribute("listeLivres", listeLivres);
System.out.println("msg resultat : "+request.getAttribute("msgResultat"));
		
		/* Transmission à la page JSP en charge de l'affichage des
		données */
		this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
