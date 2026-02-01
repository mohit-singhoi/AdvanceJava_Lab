package wipro;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCCon {
	private JDBCCon()
	{
		
	}
	private static Connection con;
	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XEPDB1","mohit","mohit");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		return con;
		
	}


}
