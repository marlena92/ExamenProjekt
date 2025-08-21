package GuiZwei;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;





public class PanelAktionen extends JPanel implements PanelAktionDelegate {
	

    
    
   

	JButton btnLoeschen;
	JButton btnSpeichern;
	JButton btnNeuesThema;
	JTextField messageArea;

	
	
	PanelAktionDelegate delegate;

	
	public PanelAktionen() {
		super();
		initComponents();
		addComponents();
		
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);

        // Message-Area
        messageArea = new JTextField();
        messageArea.setEditable(false);
        messageArea.setText("Message area");
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        add(messageArea, gbc);

        // Buttons
        gbc.gridwidth = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE; gbc.weightx = 0.0;
        
        
        // Button Löschen
        btnLoeschen = new JButton("Thema Löschen");
        gbc.gridx = 0;
        add(btnLoeschen, gbc);
        
        btnLoeschen.addActionListener(_ -> {
            if (delegate != null) delegate.deleteTheme();
        });

        
        // Button Speichern
        btnSpeichern = new JButton("Speichern");
        gbc.gridx = 1;
        add(btnSpeichern, gbc);
        
        btnSpeichern.addActionListener(_ -> {
            if (delegate != null) delegate.saveTheme();
        });

        
        // Button Neues Thema
        btnNeuesThema = new JButton("Neues Thema");
        gbc.gridx = 2;
        add(btnNeuesThema, gbc);
        
        btnNeuesThema.addActionListener(_ -> {
            if (delegate != null) delegate.newTheme();
        });

        
	}


	
	/** Initialisiert die einzelnen Komponenten des Panels
	*/
	
		void initComponents() {

		
		btnLoeschen = new JButton("Thema Löschen");
		btnLoeschen.addActionListener(_-> delegate.deleteTheme());
	
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(_-> delegate.saveTheme());
		
		btnNeuesThema = new JButton("Neues Thema");
		btnNeuesThema.addActionListener(_-> delegate.newTheme());
		
		messageArea = new JTextField();
        messageArea.setEditable(false);
        messageArea.setText("Message area");
        
       
      

	}

	
	
	
		void addComponents() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(7, 7, 7, 7);
		
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		add(messageArea, gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = 0.0;

		gbc.gridx = 0;
		add(btnLoeschen, gbc);

		gbc.gridx = 1;
		add(btnSpeichern, gbc);

		gbc.gridx = 2;
		add(btnNeuesThema, gbc);
	}

		
		public void setMessage(String message) {
	    messageArea.setText(message);
	}

	
		@Override
		public void saveTheme() {
		
		
	}

		@Override
		public void deleteTheme() {
		// TODO Auto-generated method stub
		
	}

		@Override
		public void newTheme() {
		// TODO Auto-generated method stub
		
	}

		@Override
		public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

