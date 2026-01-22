import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            // Step 1: Import is already done above
            
            // Step 2: Load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 4: Create statement and execute query
            try ( // Step 3: Establish connection
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/testdb", "root", "mohit"); // Step 4: Create statement and execute query
                    Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
                    // Step 5: Process results
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                    }
                }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
