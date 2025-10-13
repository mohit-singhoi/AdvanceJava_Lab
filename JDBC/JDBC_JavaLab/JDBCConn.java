package JDBC_JavaLab;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConn {

    public static Connection getConn() {
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; // or :xe if using SID
        String user = "mohit";
        String password = "mohit";

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // ✅ Establish connection (this is correct)
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connection established successfully!");
        } catch (Exception e) {
            System.out.print(e);
        }

        // ✅ Return the connection object (not calling a method!)
        return conn;
    }
}
