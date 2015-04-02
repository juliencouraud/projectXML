/**
 * @author julien couraud.
 *
 */
package service;


import model.*;

public final class Service {
	
    private static volatile Service instance = null;
	private Model model;
	
	public Service(){
		model = Model.getInstance();
	}
	
    public final static Service getService() {
        if (Service.instance == null) {
            synchronized(Service.class) {
                if (Service.instance == null) {
                	Service.instance = new Service();
                }
            }
        }
        return Service.instance;
    }

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public String getGroupeContact(int idUtilisateur,int idContact){
		String s = null;
		for(Contact c : Model.getInstance().getModel().get(idUtilisateur-1).getListeContacts().getListeContacts()){
			if(c.getId() == idContact){
				return c.getGroupe();
			}
		}
		return s;
	}
	
	public int checkConnection(String mail,String mdp){
		return Model.getInstance().checkConnection(mail,mdp);
	}
	
	public int checkInscription(String mail){
		return Model.getInstance().checkInscription(mail);
	}
	
	public Utilisateur getUtilisateur(int id){
		return Model.getInstance().getModel().get(id-1);
	}
	
	public void ajoutUtilisateur(int id,String nom, String prenom, String mail, String mdp){
		Utilisateur u = new Utilisateur(id,nom,prenom,mail,mdp);
		this.model.getModel().add(u);
		this.model.sauvegardeModel();
		System.out.println("Ajout nouvel utilisateur.");
	}
	
	public void modifUtilisateur(int idUtilisateur, String cle, String valeur){
		switch(cle){
		case "nom":
			Model.getInstance().getModel().get(idUtilisateur-1).setNom(valeur);
			break;
		case "prenom":
			Model.getInstance().getModel().get(idUtilisateur-1).setPrenom(valeur);
			break;
		case "mail":
			Model.getInstance().getModel().get(idUtilisateur-1).setMail(valeur);
			break;
		case "mdp":
			Model.getInstance().getModel().get(idUtilisateur-1).setMdp(valeur);
			break;
		}
		Model.getInstance().sauvegardeModel();
	}
	
	public int getIdAvecNomPrenom(String nom, String prenom){
		int id = 0;
		for(Utilisateur u: Model.getInstance().getModel()){
			if(nom.equals(u.getNom()) && prenom.equals(u.getPrenom())){
				id = u.getID();
				return id;
			}
		}
		return id;
	}
	
	public void ajouterContactToUtilisateur(int idUtilisateur, int idContact){
		Utilisateur u = Model.getInstance().getModel().get(idContact-1);
		Contact contact = new Contact(idContact,u.getNom(), u.getPrenom(), u.getMail(), "Pas de groupe");
		Model.getInstance().getModel().get(idUtilisateur-1).ajouterContact(contact);
		Model.getInstance().sauvegardeModel();
	}
	
	public void supprimerContactToUtilisateur(int idUtilisateur, int idContact){
		Model.getInstance().getModel().get(idUtilisateur-1).supprimerContact(idContact);
		Model.getInstance().sauvegardeModel();
	}
	
	public void modifGroupeContact(int idUtilisateur, int idContact, String groupe){
		Model.getInstance().getModel().get(idUtilisateur-1).modifGroupeContactContact(idContact,groupe);
		Model.getInstance().sauvegardeModel();
	}
	

}
