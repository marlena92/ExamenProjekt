package GuiZwei;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import data.DataManager;
import data.ThemaObject;



/** Die Klasse Hauptpanel ist das Haupt-Bedienfeld der GUI und organiesiert drei Sub-Panels:
 * (PanelThemenListe, PanelNeuesThema, und PanelAktionen)
 * Ausserdem verbindet HauptPanel die GUI mit der Datenverwaltungs-Logik durch eine Instanz von Data-Manager */




public class HauptPanel extends JPanel implements ListSelectionDelegate, PanelAktionDelegate {

	
	
	/** Das Panel mit der Liste aller Einträge zu den gespeicherten Themen */
	PanelThemenListe panelThemenListe;
	
	/** Das Panel beinhaltet ein Formular für neues oder zu bearbeitendes Thema */
	PanelNeuesThema panelNeuesThema;
	
	/** Das Panel enthält Buttons wie : "Speichern", "Löschen", "Neues Thema" und eine Message Anzeige */
	PanelAktionen panelAktionen;
	
	/** Instanz des DataManager-Klasse zum managen das Speichern und das Laden der Daten */
	DataManager manager = new DataManager();
	

	
	// Konstruktor des HauptPanels
	public HauptPanel() {
	super();
	initPanels();	// Initialisiert die Panels
	addPanels();	// Fügt die Panels zum Layout hinzu
	}

	
	
	
	
	/**Initialisiert die Felder (also die Panels) */
		void initPanels() {
		
		panelAktionen = new PanelAktionen();
		
		panelAktionen.delegate = this;
		
		panelThemenListe = new PanelThemenListe(); // Erstellt die Unterpanels
		panelThemenListe.setListData(manager.ladeAlleThemen()); // Initialiesiert die Liste der Themen, indem sie mit den von manager.ladeAlleThemen() geholten Daten gefüllt wird.
		panelThemenListe.delegate = this; // Weist die Delegates zu, damit das HauptPanel auf Aktionen/Events von Unterpanels reagieren kann.
	
		panelNeuesThema = new PanelNeuesThema();
	}


	
	
	/** Fügt die Panels hinzu inklusive Layout. Positioniert und fügt die drei Unterpanels auf dem Hauptpanel ein */
	
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
	}

	

		@SuppressWarnings("unused")
		
		private void initButtonActions() {

		// Speichern-Button
		panelAktionen.btnSpeichern.addActionListener(_ -> saveTheme());

		// Löschen-Button
		panelAktionen.btnLoeschen.addActionListener(_ -> deleteTheme());

		// Neues Thema-Button
		panelAktionen.btnNeuesThema.addActionListener(_ -> newTheme());
		}


	
	
		public void recieveSelectedObject(ThemaObject selection) {
		
		if (selection != null) {
			
		panelNeuesThema.titelFeld.setText(selection.getTitel());
		panelNeuesThema.infoArea.setText(selection.getInfo());
		panelAktionen.message("Thema ausgewählt.");
	}
}
	
	
	/** Speichert das aktuelle Thema aus dem Formular */
		@Override
		
		public void saveTheme() {
	    System.out.println("Thema wurde gespeichert");

	    
	    // Ein ThemaObject aus den GUI-Feldern erstellen
	    ThemaObject thema = new ThemaObject();
	    thema.setTitel(panelNeuesThema.titelFeld.getText());
	    thema.setInfo(panelNeuesThema.infoArea.getText());

	    
	    // Thema speichern über Data Manager
	    String message = manager.saveThema(thema);

	    
	    // Liste aktualisieren 
	    panelThemenListe.setListData(manager.ladeAlleThemen());
	
	    
		// Nachricht (Erfolgsmeldung) auf der GUI anzeigen
	    panelAktionen.message(message);
	}
	
	
	
	/** Eine Methode deleteTheme()*/
		
		
		public void deleteTheme() {
	    System.out.println("Thema wurde gelöscht");
		
	     
		// Ein Object aus den GUI-Feldern enfernen
		ThemaObject selected = panelThemenListe.themenListe.getSelectedValue();
	    if (selected != null) {
	   
	    	
	    // Thema Objekt aus der GUI Löschen	
	    String message = manager.deleteThema(selected);
	    
	    
	    // Liste aktualisieren und Nachricht anzeigen    
	    panelThemenListe.setListData(manager.ladeAlleThemen());
	    
	    
	    // Die Msg auf dem PanelAktionen anzeigen
	    panelAktionen.message(message);
	        
	    
	    panelNeuesThema.clearFields();
} else {
        panelAktionen.message("Kein Thema ausgewählt.");
	}
}
	
	
		
		@Override
		
		public void newTheme() {
        panelNeuesThema.clearFields();
        panelAktionen.message("Neues Thema anlegen.");

	}

	
		@Override
		
		public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}
}		

