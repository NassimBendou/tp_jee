package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Connecter
 */
@WebServlet("/connecter")
public class Connecter extends HttpServlet 
{	
	private static final long serialVersionUID = 1L;
	
	private final String LOGIN="nassim";
	private final String PASSWD="nassim";
	private final String VUE_CONNECTER="/connecter.jsp";
	private final String VUE_INDEX="index.jsp"; //sendRedirect
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connecter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		this.getServletContext().getRequestDispatcher( VUE_CONNECTER).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String login=request.getParameter("login");
		String passwd=request.getParameter("passwd");
		boolean isLogged=false;
		
		HttpSession session= request.getSession();
		if(login.equals(LOGIN) && passwd.equals(PASSWD))
		{			
			session.setAttribute("isLogged", true);
			isLogged=true;
		}
		else session.setAttribute("isLogged", false);
		if(isLogged)
			response.sendRedirect(VUE_INDEX);
		else this.getServletContext().getRequestDispatcher( VUE_CONNECTER).forward( request, response );
	}

}
