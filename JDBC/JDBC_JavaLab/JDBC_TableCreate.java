package JDBC_JavaLab;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_TableCreate {
    public static void main(String[] args) {
        try {
            // ✅ Call the static getConn() method
            Connection conn = JDBCConn.getConn();

            if (conn != null) {
                System.out.println("✅ Connected to Oracle DB successfully!");

                Statement smt = conn.createStatement();
                String sql = "CREATE TABLE ProjectGroup(" +
                             "std_id NUMBER PRIMARY KEY , " +
                             "std_name VARCHAR2(20), " +
                             "std_branch VARCHAR2(30), " +
                             "std_section NUMBER)";
                smt.executeUpdate(sql);

                System.out.println("🎉 Table 'Project Group' created successfully!");
                smt.close();
                conn.close();
            } else {
                System.out.println("❌ Connection failed! Check your DB settings.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
