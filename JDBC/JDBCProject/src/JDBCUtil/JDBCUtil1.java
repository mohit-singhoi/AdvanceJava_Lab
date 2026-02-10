package JDBCUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil1 {
	
	// Task to get the properties from the application file and loading the driver with connection
	public static Connection getJdbcConnection() throws IOException, SQLException {
		FileInputStream fis = new FileInputStream("Application.properties");
		Properties P = new Properties();
		P.load(fis);
		
		String url = P.getProperty("url");
		String user = P.getProperty("user");
		String password = P.getProperty("password");
		
		
		System.out.println("URL : " +url);
		System.out.println("USER : "+user);
		System.out.println("PASSWORD : "+password);
		
		Connection connection = DriverManager.getConnection(url,user,password);
		
		return connection;	
		
	}
	
	// Close all resources

	public static void closeResources(Connection connection , PreparedStatement preparedstatement, ResultSet resultset) throws SQLException {
		if(connection != null) {
			connection.close();	
	    }if(preparedstatement !=null) {
	    	preparedstatement.close();
	    }if(resultset !=null) {
	    	resultset.close();
	    }
		
	}

}
