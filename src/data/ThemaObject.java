package data;

public class ThemaObject {
	
	public static final String DB_COLUMN_ID = "id";
	public static final String DB_COLUMN_TITLE = "title";
	public static final String DB_COLUMN_INFO = "informationen";
	/** Anhand der ID kann man ein Thema eindeutig indentifizieren*/
	
	
	private int id;  
	public int getId() {
		return id;
	}
	
	
    /**
     * Gibt eine String-Repräsentation des ThemaObject zurück.
     * Diese wird in der JList angezeigt.
     */
	
	
	private String titel;
	
	
	
    @Override
    public String toString() {
        return titel;
    }
    
	
	private String info;
	
	public void setId(int id) {
		this.id = id;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
