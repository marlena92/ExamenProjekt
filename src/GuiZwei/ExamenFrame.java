package GuiZwei;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Die Klasse {@code ExamenFrame} stellt das Hauptfenster der Anwendung dar.
 * Sie erweitert {@link JFrame} und setzt ein {@code HauptPanel} als
 * Content-Pane.
 * <p>
 * Diese Klasse ist verantwortlich für die Initialisierung des Hauptfensters
 * mit spezifischen Einstellungen und dient als Einstiegspunkt der Anwendung.
 * </p>
 * 
 * @author [Ihr Name]
 * @version 1.0
 * @see HauptPanel
 */
public class ExamenFrame extends JFrame {
                  
    /**
     * Erstellt ein neues {@code ExamenFrame}-Objekt mit voreingestellten
     * Fenstereigenschaften wie Titel, Größe, Position und
     * einem zentralen {@code HauptPanel}.
     * <p>
     * Folgende Einstellungen werden vorgenommen:
     * <ul>
     *   <li>Fenstertitel wird auf "Examen" gesetzt</li>
     *   <li>Standardaktion beim Schließen wird auf EXIT_ON_CLOSE gesetzt</li>
     *   <li>Fenstergröße wird auf 800x400 Pixel gesetzt</li>
     *   <li>Fenster wird auf dem Bildschirm zentriert</li>
     *   <li>Ein neues {@code HauptPanel} wird als Content-Pane gesetzt</li>
     * </ul>
     * </p>
     */
    public ExamenFrame() {
            setTitle("Examen"); 
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 400);
            setLocationRelativeTo(null);
            setContentPane(new HauptPanel());
    }

    /**
     * Einstiegspunkt der Anwendung.
     * <p>
     * Erstellt eine neue Instanz von {@code ExamenFrame} und macht sie sichtbar.
     * Die Erstellung erfolgt im Event-Dispatch-Thread von Swing, um
     * Thread-Sicherheit zu gewährleisten.
     * </p>
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new ExamenFrame().setVisible(true));
    }
}
