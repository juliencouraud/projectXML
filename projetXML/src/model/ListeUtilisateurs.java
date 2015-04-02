/**
 * @author julien couraud.
 *
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class ListeUtilisateurs {
	
	private List<Utilisateur> listeUtilisateur;
	
	public ListeUtilisateurs(){
		this.listeUtilisateur = new ArrayList<Utilisateur>();
	}

	public List<Utilisateur> getListeUtilisateur() {
		return listeUtilisateur;
	}

	public void setListeUtilisateur(List<Utilisateur> listeUtilisateur) {
		this.listeUtilisateur = listeUtilisateur;
	}
	
	

}
