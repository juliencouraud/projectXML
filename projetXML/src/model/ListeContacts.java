/**
 * @author julien couraud.
 *
 */
package model;

import java.util.ArrayList;
import java.util.List;


public class ListeContacts {
	
	private List<Contact> listeContacts;
	
	public ListeContacts(){
		this.listeContacts = new ArrayList<Contact>();
	}

	public List<Contact> getListeContacts() {
		return listeContacts;
	}

	public void setListeContacts(List<Contact> listeContacts) {
		this.listeContacts = listeContacts;
	}
	
	public void ajouterContact(Contact u){
		listeContacts.add(u);
	}
	
	public boolean estVide(){
		return this.listeContacts.isEmpty();
	}
	
	public Contact getContactAvecId(int id){
		for(Contact c: listeContacts){
			if(c.getId() == id){
				return c;
			}
		}
		return null;
	}
	

}
