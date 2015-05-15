import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnect {

	
	public static int gameID =2;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	public DBConnect() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1","root","");
			st = con.createStatement();
			
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	
	public void getData() {
		try{
			
			String query =  "select * from Game";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");
			while(rs.next()) {
				int gameID = rs.getInt("GameID");
				int intrest = rs.getInt("Intrest");
				System.out.println("GameID: "+gameID+"          Intrest: "+intrest);
			}
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	
	public void addData() {
		try{
			
			String sql =  "insert into Game "
						 +	" (GameID, Intrest)"
						 +	" values ('520', '17')";
			st.executeUpdate(sql);		
					
			
		
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}

	public void createTable() {
		try{
			
			String sql =  	"CREATE TABLE game"+ gameID +
    		  				" (GameTurn int, "
    		  				+ "GameID int, "
    		  				+ "Intrest int)" ;;
			st.executeUpdate(sql);		
					
			
		
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
}

