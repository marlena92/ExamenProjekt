package GuiZwei;

import javax.swing.event.ListSelectionEvent;

/** Ein PanelAktionenDelegate soll sich drum kümmern um die Aktionen nach dem Klick auf Buttons: 
 * "ThemaSpeichern" das Thema zu speichern,nach dem Klick auf Button "ThemaLöschen" das Thema zu löschen, und nach dem Klick auf Button "NeuesThema"
 *  um die Anzeige des Themeneditors.*/ 

public interface PanelAktionDelegate {
	
	
	public void saveTheme();
	
	public void deleteTheme();
	
	public void newTheme();

	void valueChanged(ListSelectionEvent e);
}
