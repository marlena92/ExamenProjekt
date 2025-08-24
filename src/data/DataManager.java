package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Die Klasse kümmert sich um das Speichern der Daten und das Laden der
 * gespeicherten Daten
 */


public class DataManager {

		/**Link zu der Datenbank */
		private static final String URL = "jdbc:mysql://localhost:3306/marlenaexamen";
		
		/** Benutzer*/
		private static final String USER = "root";
	    
		/**Password*/
		private static final String PASSWORD = "Kotek150292";

	
	
		public String saveThema(ThemaObject thema) {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String command;

			if (thema.getId() > 0) {
				command = "INSERT INTO marlenaexamen.thema (TITLE, INFORMATIONEN, ID) VALUES (?, ?, ?);";
			}else {
				command = "UPDATE marlenaexamen.thema SET TITLE = ?, INFORMATIONEN = ? WHERE (ID = ?);";
			}
			
			
			PreparedStatement stmt = connection.prepareStatement(command,
			Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, thema.getTitel());
			stmt.setString(2, thema.getInfo());
			stmt.setInt(3, thema.getId());
			
		if  (thema.getId() > 0)
			stmt.setInt(3, thema.getId());
			stmt.execute();

			ResultSet res = stmt.getGeneratedKeys();
		if  (res.next()) {
			thema.setId(res.getInt(1));
			}
			stmt.close();
		    }
	  catch (SQLException e) {
			e.printStackTrace();
		    }
		
	 return "Das Thema wurde unter id " + thema.getId() + " gespeichert";
}
 
	/**
	 * Diese Methode lädt alle gespeicherten Themen und liefert diese in Form einer
	 * Liste aus.
	 * 
	 * @return Liste mit Instanzen der Klasse ThemaObject
	 */

	public ArrayList<ThemaObject> ladeAlleThemen() {

		   ArrayList<ThemaObject> liste = new ArrayList<ThemaObject>();

		   ThemaObject thema;

	  for  (int i = 1; i < 11; i++) {

		   thema = new ThemaObject();
		   thema.setTitel("Titel des Thema Nr. " + i);
		   thema.setInfo("Information zum Thema Nr. " + i);

		   liste.add(thema);
		}

		  return liste;
	}

		public String deleteThema(ThemaObject selected) {
		// TODO Auto-generated method stub
		return null;
	}
}