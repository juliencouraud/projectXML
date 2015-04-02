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
 * Servlet implementation class Modification
 */
@WebServlet(name = "Modification")
public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/modification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cle = request.getParameter("radio");
		String valeur = request.getParameter("nouveau");
	    Service service = Service.getService();
    	HttpSession session = request.getSession(); 
    	int idUtilisateur = (int) session.getAttribute("idUtilisateur");
        service.modifUtilisateur(idUtilisateur,cle,valeur);
        System.out.println("ID de modification: "+idUtilisateur);
        Utilisateur u = service.getUtilisateur(idUtilisateur);
    	request.setAttribute("utilisateur", u);
        System.out.println("Modification réussie.");
		this.getServletContext().getRequestDispatcher("/WEB-INF/indexUtilisateur.jsp").forward(request, response);
	}

}
