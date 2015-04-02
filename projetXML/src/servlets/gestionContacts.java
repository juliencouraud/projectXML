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

import service.Service;
import model.ListeGroupes;
import model.ListeUtilisateurs;
import model.Utilisateur;

/**
 * Servlet implementation class gestionContacts
 */
@WebServlet(name = "gestionContacts")
public class gestionContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gestionContacts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    Service service = Service.getService();
    	HttpSession session = request.getSession(); 
    	int idUtilisateur = (int) session.getAttribute("idUtilisateur");
        Utilisateur utilisateur = service.getUtilisateur(idUtilisateur);

		ListeGroupes groupes = service.getModel().getGroupes();
		ListeUtilisateurs listeUtilisateurs = new ListeUtilisateurs();
		listeUtilisateurs.setListeUtilisateur(Service.getService().getModel().getModel());
		

		request.setAttribute("groupes", groupes);
		request.setAttribute("utilisateur", utilisateur);
		request.setAttribute("listeUtilisateurs", listeUtilisateurs);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/gestionContacts.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String action = request.getParameter("action");
		Service service = Service.getService();
		HttpSession session = request.getSession();
		int idUtilisateur = (int) session.getAttribute("idUtilisateur");
		int idContact = service.getIdAvecNomPrenom(nom, prenom);
		switch (action) {
		case "modifier":
			String groupe = request.getParameter("selectGroupe");
			service.modifGroupeContact(idUtilisateur, idContact, groupe);
			System.out.println("[Modification]Nom: " + nom + ", Prénom: "
					+ prenom);
			break;
		case "ajouter":
			service.ajouterContactToUtilisateur(idUtilisateur, idContact);
			System.out.println("[Ajout]Nom: " + nom + ", Prénom: " + prenom);
			break;
		case "supprimer":
			service.supprimerContactToUtilisateur(idUtilisateur, idContact);
			System.out.println("[Suppression]Nom: " + nom + ", Prénom: "
					+ prenom);
			break;
		}

	}

}
