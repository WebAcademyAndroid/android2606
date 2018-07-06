
public class DataBase {

	private static DataBase db;
	
	private DataBase() {
		
	}
	
	public static DataBase getInstace() {
		if(db == null) {
			db = new DataBase();
		}
		
		return db;
	}
	
	
	public void save() {
		
	}
	
}
