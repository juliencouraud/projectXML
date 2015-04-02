/**
 * @author julien couraud.
 *
 */
package model;

import java.util.Iterator;

public class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private ListeContacts listeContacts;

	public Utilisateur(){
		this.listeContacts = new ListeContacts();
	}
	
	public Utilisateur(int id,String nom, String prenom, String mail,String mdp){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.listeContacts = new ListeContacts();
	}
	
	public int getID(){
		return this.id;
	}
	
	public void setID(int id){
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ListeContacts getListeContacts() {
		return listeContacts;
	}

	public void setListeContacts(ListeContacts listeContacts) {
		this.listeContacts = listeContacts;
	}
	
	public String getMdp(){
		return this.mdp;
	}
	
	public void setMdp(String mdp){
		this.mdp = mdp;
	}
	
	public boolean estContact(int id){
		for(Contact c: listeContacts.getListeContacts()){
			if(c.getId() == id){
				return true;
			}
		}
		return false;
	}
	
	
	public Contact utilisateurToContact(int idContact, String groupe){
		return new Contact(idContact, nom,prenom,mail,groupe);
	}
	
	public String getGroupeContact(int idContact){
		String s="";
		for(Contact c: listeContacts.getListeContacts()){
			if(c.getId()==idContact){
				return c.getGroupe();
			}
		}
		return s;
	}
	
	public String printUtilisateurJSP(){
		String contact = "</br>";
		contact += "<b>";
		contact += getPrenom();
		contact += " ";
		contact += getNom();
		contact +="</b></br>";
		contact += getMail();
		contact += "</br>";
		return contact;
	}
	
	public void ajouterContact(Contact c){
		listeContacts.ajouterContact(c);
	}
	
	public void supprimerContact(int idContact){
		Iterator<Contact> i = listeContacts.getListeContacts().iterator();
		while (i.hasNext()) {
			Contact c = i.next();
			if(c.getId() == idContact){
				i.remove();
			}
		}
	}
	
	public void modifGroupeContactContact(int idContact, String groupe){
		for(Contact c: listeContacts.getListeContacts()){
			if(c.getId() == idContact){
				c.setGroupe(groupe);
			}
		}
	}
	
}
