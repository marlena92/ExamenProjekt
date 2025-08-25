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
 * gespeicherten Daten*/


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
				        PreparedStatement stmt;

				        if (thema.getId() <= 0) {
				            // Neues Thema einfügen, ID wird von MySQL generiert
				            command = "INSERT INTO marlenaexamen.thema (TITLE, INFORMATIONEN) VALUES (?, ?)";
				            stmt = connection.prepareStatement(command, Statement.RETURN_GENERATED_KEYS);
				            stmt.setString(1, thema.getTitel());
				            stmt.setString(2, thema.getInfo());
				        } else {
				            // Bestehendes Thema aktualisieren
				            command = "UPDATE marlenaexamen.thema SET TITLE = ?, INFORMATIONEN = ? WHERE ID = ?";
				            stmt = connection.prepareStatement(command);
				            stmt.setString(1, thema.getTitel());
				            stmt.setString(2, thema.getInfo());
				            stmt.setInt(3, thema.getId());
				        }

				        int affectedRows = stmt.executeUpdate();

				        if (affectedRows == 0)
				            throw new SQLException("Speichern des Themas fehlgeschlagen, keine Zeilen betroffen.");

				        // Wenn es ein INSERT war, generierte ID auslesen
				        if (thema.getId() <= 0) {
				            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				                if (generatedKeys.next()) {
				                    thema.setId(generatedKeys.getInt(1));
				                } else {
				                    throw new SQLException("Speichern des Themas fehlgeschlagen, keine ID erhalten.");
				                }
				            }
				        }

				        stmt.close();
				        connection.close();
				        return "Das Thema wurde unter id " + thema.getId() + " gespeichert";

				    } catch (SQLException e) {
				        e.printStackTrace();
				        return "Fehler beim Speichern des Themas: " + e.getMessage();
				    }
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