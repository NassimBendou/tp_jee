package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/servletTest")
public class ServletTest extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int cpt=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String msgP=request.getParameter("msg");
		HttpSession session=request.getSession();
		session.setAttribute("cpt",++cpt );
		
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<title>Test Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Bonjour</h2>");
		if(msgP!=null)
			out.println("<p>le message que vous avez envoyé : "+msgP+"</p>");
		else
			out.println("<p>vous n'avez pas envoyé de message</p>");
		out.println("<p>Nombre de rechargement de la page : "+cpt+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
