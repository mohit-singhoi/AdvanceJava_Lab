package JDBC_Application_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USERNAME = "mohit";
    private static final String PASSWORD = "mohit";
    private static Connection connection = null;
    
    // Private constructor to prevent instantiation
    private DatabaseConnection() {}
    
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load Oracle JDBC driver
                Class.forName("oracle.jdbc.driver.OracleDriver");
                
                // Establish connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                connection.setAutoCommit(false); // Manual transaction control
                System.out.println("✅ Database connection established successfully!");
                
            } catch (ClassNotFoundException e) {
                System.out.println("❌ Oracle JDBC Driver not found!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("❌ Connection failed!");
                System.out.println("Error: " + e.getMessage());
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("✅ Database connection closed.");
            } catch (SQLException e) {
                System.out.println("❌ Error closing connection: " + e.getMessage());
            }
        }
    }
    
    public static void commit() {
        if (connection != null) {
            try {
                connection.commit();
                System.out.println("✅ Transaction committed.");
            } catch (SQLException e) {
                System.out.println("❌ Error committing transaction: " + e.getMessage());
            }
        }
    }
    
    public static void rollback() {
        if (connection != null) {
            try {
                connection.rollback();
                System.out.println("✅ Transaction rolled back.");
            } catch (SQLException e) {
                System.out.println("❌ Error rolling back transaction: " + e.getMessage());
            }
        }
    }
    
    public static boolean testConnection() {
        try {
            Connection conn = getConnection();
            if (conn != null && !conn.isClosed()) {
                return conn.createStatement().execute("SELECT 1 FROM dual");
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
}