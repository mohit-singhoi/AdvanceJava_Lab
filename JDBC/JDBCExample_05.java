import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample_05 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish Connection
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/XEPDB1", // Database URL
                "mohit",                              // Username
                "mohit"                             // Password
            );

            System.out.println("Connection established successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found. Add ojdbc.jar to classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console.");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed successfully.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
