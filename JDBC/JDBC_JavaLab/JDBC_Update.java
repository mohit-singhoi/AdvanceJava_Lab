package JDBC_JavaLab;

import java.sql.*;
import java.io.*;

public class JDBC_Update {
	
    public static void main(String[] args) {
        try {
            // ✅ Get connection from JDBCConn class
            Connection conn = JDBCConn.getConn();

            if (conn != null) {
                System.out.println("✅ Connected to Oracle DB successfully!");

                // ✅ Prepare the UPDATE statement
                PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE ProjectGroup SET std_name = ?, std_branch = ?, std_section = ? WHERE std_id = ?"
                );

                // ✅ Take input from user
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Enter Student ID to Update: ");
                int std_id = Integer.parseInt(br.readLine());

                System.out.print("Enter New Student Name: ");
                String std_name = br.readLine();

                System.out.print("Enter New Branch: ");
                String std_branch = br.readLine();

                System.out.print("Enter New Section: ");
                int std_section = Integer.parseInt(br.readLine());

                // ✅ Set parameters in prepared statement
                pstmt.setString(1, std_name);
                pstmt.setString(2, std_branch);
                pstmt.setInt(3, std_section);
                pstmt.setInt(4, std_id);

                // ✅ Execute update
                int count = pstmt.executeUpdate();

                if (count > 0) {
                    System.out.println("✅ Record updated successfully!");
                } else {
                    System.out.println("⚠️ No record found with ID: " + std_id);
                }

                // ✅ Close resources
                pstmt.close();
                conn.close();
            } else {
                System.out.println("❌ Connection failed! Could not update data.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
