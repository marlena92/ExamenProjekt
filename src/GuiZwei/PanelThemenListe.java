package GuiZwei;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import data.ThemaObject;



public class PanelThemenListe extends JPanel implements ListSelectionListener {

	JList<ThemaObject> themenListe;
	
	ListSelectionDelegate delegate;

	
	
	public PanelThemenListe() {

		super();
		initList();
		addList();
	}

	
	
	/**
	 * Initialisiert das Feld themenListe und füllt es mit Daten.
	 */
	
	private void initList() {

		themenListe = new JList<ThemaObject>();
		themenListe.setFont(new Font("Serif", Font.PLAIN, 15));
		themenListe.addListSelectionListener(this);
	}
	
	/**
	 * Erstelt aus einer Liste mit ThemaObject-Objekten ein Model für die JList.
	 * @param listData
	 */
	public void setListData(ArrayList<ThemaObject> listData) {
		
		DefaultListModel<ThemaObject> model = new DefaultListModel<ThemaObject>();
		for (ThemaObject th : listData) {
			model.addElement(th);
		}
		themenListe.setModel(model);
	}

	void addList() {

		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createTitledBorder("Themen"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		JScrollPane scrollPane = new JScrollPane(themenListe);

		add(scrollPane, gbc);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {
		    // Auswahl fertig – jetzt reagieren!
		    ThemaObject selected = themenListe.getSelectedValue();
		    delegate.recieveSelectedObject(selected);
		}
	}
}
