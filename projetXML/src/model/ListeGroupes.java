/**
 * @author julien couraud.
 *
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class ListeGroupes {

	private List<String> groupes;
	
	public ListeGroupes(){
		this.groupes = new ArrayList<String>();
	}
	
	public List<String> getListeGroupes(){
		return this.groupes;
	}
}
