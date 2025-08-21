package GuiZwei;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelNeuesThema extends JPanel {

	JTextField titelFeld;
	JLabel titelFeldLabel;

	JLabel infoAreaLabel;
	JTextArea infoArea;

	public PanelNeuesThema() {
		super();
		initComponents();
		addComponents();
	}

	void initComponents() {
		
		titelFeldLabel = new JLabel("Titel");
		titelFeld = new JTextField(18);
		
		infoAreaLabel = new JLabel("Information zum Thema");
		infoArea = new JTextArea(7, 22);
	}

	void addComponents() {
		
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Neues Thema"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridx = 0;
		gbc.gridy = 0;

		add(titelFeldLabel, gbc);

		gbc.gridx = 1;
		add(titelFeld, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(14, 6, 6, 6);
		add(infoAreaLabel, gbc);

		JScrollPane infoScroll = new JScrollPane(infoArea);
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(infoScroll, gbc);
	}

	public void clearFields() {
        titelFeld.setText("");
        infoArea.setText("");
    }


    public String getTitel() {
        return titelFeld.getText();
    }

    public String getInfo() {
        return infoArea.getText();
   }
 }
