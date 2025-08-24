package GuiZwei;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class PanelAktionen extends JPanel  {
	
private JLabel messageLabel; // z.B. ein Label zum Anzeigen von Nachrichten
    
    public void message(String message) {
        messageLabel.setText(message);
    }


	JButton btnLoeschen;
	JButton btnSpeichern;
	JButton btnNeuesThema;
	JTextField messageArea;

	
	
	PanelAktionDelegate delegate;

	
	public PanelAktionen() {
		super();
		initComponents();
		addComponents();
	}
	void initComponents() {
	    btnLoeschen = new JButton("Thema Löschen");
	    btnLoeschen.addActionListener(_ -> {
	        if (delegate != null) delegate.deleteTheme();
	    });

	    btnSpeichern = new JButton("Speichern");
	    btnSpeichern.addActionListener(_ -> {
	        if (delegate != null) delegate.saveTheme();
	    });

	    btnNeuesThema = new JButton("Neues Thema");
	    btnNeuesThema.addActionListener(_ -> {
	        if (delegate != null) delegate.newTheme();
	    });

	    messageArea = new JTextField();
	    messageArea.setEditable(false);
	    messageArea.setText("Message area");

	    messageLabel = new JLabel("Starttext");
	}


		void addComponents() {
			
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(7, 7, 7, 7);
			
			// 1. Zeile: messageArea
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 3;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.weightx = 1.0;
			add(messageArea, gbc);

			// 2. Zeile: messageLabel
			gbc.gridy = 1;
			add(messageLabel, gbc);

			// 3. Zeile: Buttons
			gbc.gridwidth = 1;
			gbc.gridy = 2;
			gbc.fill = GridBagConstraints.NONE;
			gbc.weightx = 0.0;

			gbc.gridx = 0;
			add(btnLoeschen, gbc);

			gbc.gridx = 1;
			add(btnSpeichern, gbc);

			gbc.gridx = 2;
			add(btnNeuesThema, gbc);

		}
	}