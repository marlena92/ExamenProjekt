package data;

import java.util.ArrayList;




/** Die Klasse kümmert sich um das Speichern der Daten
 * und das Laden der gespeicherten Daten.
 */

public class DataManager {
	
	
	/**Eine Methode um Thema zu Speichern */
	
	public String saveThema(ThemaObject thema) {
		return "Das Speichern ist noch nicht implementiert";
	}
	
	
	/** Eine Methode um Thema zu Löschen */
	
	public String deleteThema(ThemaObject selected) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
    /** 
     * Lädt alle gespeicherten Themen und liefert diese als Liste zurück.
     * 
     * @return Liste mit Instanzen der Klasse ThemaObject
     */
    public ArrayList<ThemaObject> ladeAlleThemen() {
    	
        ArrayList<ThemaObject> liste = new ArrayList<ThemaObject>();
        
        ThemaObject thema;
        
        for (int i = 1; i < 11; i++) {
        	
            thema = new ThemaObject();
            thema.setTitel("Titel des Thema Nr. " + i);
            thema.setInfo("Informationen zum Thema Nr. " + i);
            
            liste.add(thema);
        }
        
        return liste;
    }
}


