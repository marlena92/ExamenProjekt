package GuiZwei;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

import data.DataManager;
import data.ThemaObject;



/**
 * Das Haupt der vier Panels der gesamten GUI. Die weiteren drei Panels sind
 * ihre Sub-Panels. Diese Klasse ist auch für den Datentransport zu und von dem
 * Teil der Anwendung, der für die Datenspeicherung verantwortlich ist.
 */


public class HauptPanel extends JPanel implements ListSelectionDelegate, PanelAktionDelegate {

	
	/**
	 * Das Panel mit der Liste aller Einträge zu den gespeicherten Themen.
	 */
	
	PanelThemenListe panelThemenListe;
	
	
	/**
	 * Das Panel, auf dem ein Thema bearbeitet werden kann oder ein Daten zu einem
	 * neuen Thema eingetragen werden können.
	 */
	
	PanelNeuesThema panelNeuesThema;
	
	
	/**
	 * Das Panel mit den Buttons "Speichern", "Löschen" und "Neues Thema" und dem
	 * Platzhalter für Fehlermeldungen.
	 */
	
	PanelAktionen panelAktionen;
	
	
	
	
	
	/**
	 * Instanz des DataManager-Klasse zum managen das Speichern und das Laden der
	 * Daten;
	 */
	
	DataManager manager = new DataManager();
	

	
	/** Konstruktor */
	
	public HauptPanel() {
		super();
		initPanels();
		addPanels();
	}

	
	
	/**
	 * Initialisiert die Felder (also die Panels)
	 */

	void initPanels() {
		
		
		panelThemenListe = new PanelThemenListe();
		panelThemenListe.setListData(manager.ladeAlleThemen());
		panelThemenListe.delegate = this;
		
	
		panelNeuesThema = new PanelNeuesThema();
		
		
		panelAktionen = new PanelAktionen();
		panelAktionen.delegate = this;
	}


	/**
	 * Fügt die Panels hinzu (addet) inkl. Layout
	 */
	void addPanels() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Linkes Panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(15, 10, 0, 5);
		gbc.fill = GridBagConstraints.BOTH;
		add(panelNeuesThema, gbc);

		// Rechtes Panel
		gbc.gridx = 1;
		gbc.insets = new Insets(15, 5, 0, 10);
		add(panelThemenListe, gbc);

		// Unteres Panel
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(5, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(panelAktionen, gbc);

		// ActionListener für Buttons hinzufügen
        initButtonActions();

	}

	
	/**
    * Initialisiert die ActionListener für die Buttons im PanelAktionen.
    */
	
	private void initButtonActions() {
		// TODO Auto-generated method stub
		
	}

	public void recieveSelectedObject(ThemaObject selection) {

		panelNeuesThema.titelFeld.setText(selection.getTitel());
		panelNeuesThema.infoArea.setText(selection.getInfo());
		panelAktionen.setMessage("Thema ausgewählt.");
	}

	
	
	/** Eine Methode saveTheme()*/
	@Override
	public void saveTheme() {
	    System.out.println("Thema wurde gespeichert");

	    // Ein ThemaObject aus den GUI-Feldern erstellen
	    ThemaObject thema = new ThemaObject();
	    thema.setTitel(panelNeuesThema.titelFeld.getText());
	    thema.setInfo(panelNeuesThema.infoArea.getText());

	    // Thema speichern
	    String message = manager.saveThema(thema);

	    // Liste aktualisieren und Nachricht anzeigen
	    panelThemenListe.setListData(manager.ladeAlleThemen());
	
		//TODO Die Msg auf dem PanelAktionen anzeigen
	    panelAktionen.setMessage(message);
	}
	
	
	/** Eine Methode deleteTheme()*/
	@Override
	public void deleteTheme() {
	    System.out.println("Thema wurde gelöscht");
		
		// Ein Object aus den GUI-Feldern enfernen
		ThemaObject selected = panelThemenListe.themenListe.getSelectedValue();
	    if (selected != null) {
	   
	    // Thema Löschen	
	    String message = manager.deleteThema(selected);
	        
	    // Liste aktualisieren und Nachricht anzeigen    
	    panelThemenListe.setListData(manager.ladeAlleThemen());
	    
	    // Die Msg auf dem PanelAktionen anzeigen
	    panelAktionen.setMessage(message);
	        
	    
	    panelNeuesThema.clearFields();
	    } else {
            panelAktionen.setMessage("Kein Thema ausgewählt.");

	}

}
	@Override
	public void newTheme() {
        panelNeuesThema.clearFields();
        panelAktionen.setMessage("Neues Thema anlegen.");

	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}		

