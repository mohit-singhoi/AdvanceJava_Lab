package JDBC_JavaLab;

import java.sql.*;

public class JDBC_Select {
    public static void main(String[] args) {
        try {
            // ✅ Get connection from JDBCConn class
            Connection conn = JDBCConn.getConn();

            if (conn != null) {
                System.out.println("✅ Connected to Oracle DB successfully!");

                // ✅ Create a statement
                Statement smt = conn.createStatement();

                // ✅ Execute SELECT query
                ResultSet rs = smt.executeQuery("SELECT * FROM ProjectGroup");

                // ✅ Process result set
                System.out.println("\n--- Student Records ---");
                while (rs.next()) {
                    int std_id = rs.getInt(1);
                    String std_name = rs.getString(2);
                    String std_branch = rs.getString(3);
                    int std_section = rs.getInt(4);

                    System.out.println("-----------------------------");
                    System.out.println("Student ID      : " + std_id);
                    System.out.println("Student Name    : " + std_name);
                    System.out.println("Student Branch  : " + std_branch);
                    System.out.println("Student Section : " + std_section);
                }

                // ✅ Close resources
                rs.close();
                smt.close();
                conn.close();

                System.out.println("\n✅ Data fetched successfully!");
            } else {
                System.out.println("❌ Connection failed! Could not fetch data.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
