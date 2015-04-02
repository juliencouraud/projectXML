/**
 * @author julien couraud.
 *
 */
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utilisateur;
import service.Service;


/**
 * Servlet implementation class indexUtilisateur
 */
@WebServlet(name = "indexUtilisateur")
public class indexUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    Service service = Service.getService();
    	HttpSession session = request.getSession(); 
    	int idUtilisateur = (int) session.getAttribute("idUtilisateur");
        Utilisateur u = service.getUtilisateur(idUtilisateur);
    	request.setAttribute("utilisateur", u);
		this.getServletContext().getRequestDispatcher("/WEB-INF/indexUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
