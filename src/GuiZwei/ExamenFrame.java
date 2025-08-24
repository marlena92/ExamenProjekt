package GuiZwei;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Die Klasse richtet das Hauptfenster der App ein.
 * Sie kümmert sich um Fenstereigenschaften( Grösse, Titel, Position, Schliessen).
 * Sie bettet grafische Bedienoberfläche ( Hauptpanel ) ins Fenster ein.
 * Sie definiert den Prgrammstart.
 * 
 * @author [Marlena Szutran]
 * @version 1.0
 */


/**
 * Erstellt ein neues Objekt mit voreingestellten
 * Fenstereigenschaften wie Titel, Größe, Position.
 * 
 * Folgende Einstellungen werden vorgenommen:
 * 
 * Fenstertitel wird auf "Examen" gesetzt</li>
 * Standardaktion beim Schließen wird auf EXIT_ON_CLOSE gesetzt</li>
 * Fenstergröße wird auf 800x400 Pixel gesetzt</li>
 * Fenster wird auf dem Bildschirm zentriert</li>
 * Ein neues {@code HauptPanel} wird als Content-Pane gesetzt</li>
 * 
 */



public class ExamenFrame extends JFrame {
                  
    
	
	
		// Konstruktor
		public ExamenFrame() {
        
		setTitle("Examen"); // Fenstertitel					
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Schliessen-Verhalten
        setSize(800, 400); // Grösse des Fensters
        setLocationRelativeTo(null); //Zentrierung
        setContentPane(new HauptPanel()); // Content Pane setzen
    }

/** Einstiegspunkt der Anwendung */
    
		// main-Methode
		public static void main(String[] args) {
    	
    	  /** Methode SwingUtiliteies. invokeLater sorgt dafür dass der übergebene Codeblock 
    	  (das sogenannte Runnable) im EDT ausgeführt wird – also im Thread, der für die GUI zuständig ist.*/
    	  SwingUtilities.invokeLater(() -> new ExamenFrame().setVisible(true));	// Es wird ein ExamenFrame erstellt und sichbaar gemacht.
    }
}
