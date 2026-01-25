package JDBC_Application_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App_conn {
    
    public static Connection getConnection() {
        Connection conn = null;
        // Fixed URL - "oracle" not "orecle"
        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; 
        String user = "mohit";
        String password = "mohit";

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        
        return conn;
    }
    
    // Add a main method to test the connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}