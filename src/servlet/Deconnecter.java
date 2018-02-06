package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deconnnecter
 */
@WebServlet("/deconnecter")
public class Deconnecter extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private final String VUE_INDEX_FORWARD="/index.jsp";
	private final String VUE_INDEX_REDIRECT="index.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deconnecter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session=request.getSession();
		session.setAttribute("isLogged", false);
		session.invalidate();
	
		//session.setAttribute("isLogged", false);
		//this.getServletContext().getRequestDispatcher(VUE_INDEX_FORWARD).forward(request,response);
		response.sendRedirect(VUE_INDEX_REDIRECT);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
