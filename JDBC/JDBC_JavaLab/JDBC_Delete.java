package JDBC_JavaLab;

import java.sql.*;
import java.io.*;

public class JDBC_Delete {
	
    public static void main(String[] args) {
        try {
        	
            // ✅ Get connection from JDBCConn class
            Connection conn = JDBCConn.getConn();

            if (conn != null) {
                System.out.println("✅ Connected to Oracle DB successfully!");

                // ✅ Create Statement object
                Statement stmt = conn.createStatement();

                // ✅ Get user input
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                while(true) {
                System.out.print("Enter Student ID to delete: ");
                int std_id = Integer.parseInt(br.readLine());

                // ✅ Build SQL query (⚠️ vulnerable to SQL injection — for learning only)
                String sql = "DELETE FROM ProjectGroup WHERE std_id = " + std_id;

                // ✅ Execute DELETE query
                int count = stmt.executeUpdate(sql);

                if (count > 0) {
                    System.out.println("✅ Record deleted successfully!");
                } else {
                    System.out.println("⚠️ No record found with ID: " + std_id);
                }
                
                System.out.println("Do you want to delete More Records[Yes/No]");
                
                String ch = br.readLine();
                if(ch.equalsIgnoreCase("no")) 
                	break;
            }

                // ✅ Close resources
                stmt.close();
                conn.close();
                System.out.println("✅ Connection closed successfully.");
            } else {
                System.out.println("❌ Connection failed! Could not delete data.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
