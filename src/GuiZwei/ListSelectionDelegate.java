package GuiZwei;

import data.ThemaObject;

/**
 * Das Interface definiert eine Schnittstelle, die verwendet wird, um
 * auf die Auswahl eines Elements aus einer Liste zu reagieren.
 *
 * Eine Klasse, die dieses Interface implementiert, kann als "Delegat"
 * fungieren, das den ausgewählten Listeneintrag für weitere Verarbeitung 
 * erhält.
 * 
 */
public interface ListSelectionDelegate {

	/**
     * Wird aufgerufen, wenn ein Objekt in einer Liste ausgewählt wurde.
	 * @param selection Das selektierte Objekt
	 */
	public void recieveSelectedObject(ThemaObject selection);
//	public void recieveSelectedObject(String selection);

}