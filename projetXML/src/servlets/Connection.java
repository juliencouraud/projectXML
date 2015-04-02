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
 * Servlet implementation class Connection
 */
@WebServlet(name = "Connection")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mail;
	private String mdp;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.mail = request.getParameter("mail");
	    this.mdp = request.getParameter("mdp");
	    Service service = Service.getService();
        int idUtilisateur = service.checkConnection(mail,mdp);
	    if(idUtilisateur == 0){
	    	System.out.println("Connection échec.");
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	    }
	    else{
	    	HttpSession session = request.getSession(); 
	    	session.setAttribute("idUtilisateur", idUtilisateur);
	        Utilisateur u = service.getUtilisateur(idUtilisateur);
	    	request.setAttribute("utilisateur", u);
	        System.out.println("Connection réussie.");
	    	this.getServletContext().getRequestDispatcher("/WEB-INF/indexUtilisateur.jsp").forward(request, response);
	    }
	}

}
