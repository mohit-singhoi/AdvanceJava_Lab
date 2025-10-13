package JDBC_JavaLab;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.sql.SQLException;
import java.sql.*;
import java.io.*;

public class JDBC_insert {
    public static void main(String[] args) {
    	int count =0;
        try {
            // ✅ Get connection from JDBCConn class
            Connection conn = JDBCConn.getConn();

            if (conn != null) {
                System.out.println("✅ Connected to Oracle DB successfully!");

                
                
                //// Insert data Directly by Writing Here 
                // ✅ Create a statement
//                Statement smt = conn.createStatement();

                // ✅ Insert 5 sample records																																																																																																																																																																																																																																																																																																										
//                String[] inserts = {
//                    "INSERT INTO ProjectGroup VALUES (379, 'Mohit Kumar', 'MCA', 5)",
//                    "INSERT INTO ProjectGroup VALUES (376, 'Raja Babu', 'MCA', 5)",
//                    "INSERT INTO ProjectGroup VALUES (398, 'Ankit kumar', 'MCA', 5)"
                		
//                	   "INSERT INTO ProjectGroup VALUES (260, 'Amit pal', 'MCA', 5)"
                		
//                		"INSERT INTO ProjectGroup VALUES (127, 'Abhishek Pandey', 'MCA', 5)",
//                		"INSERT INTO ProjectGroup VALUES (448, 'Gopal Kumar', 'MCA', 5)"
                  
//                };

                // Execute each insert
//                for (String query : inserts) {
//                    smt.executeUpdate(query);
//                    count++;
//                    
//                }
//                System.out.println(count+" Records inserted successfully into Project Group!");
//
//                // Close resources
//                smt.close();
//                conn.close();
//                
//                
                
                
                ////Insert data by user Command line
            	PreparedStatement pstm = conn.prepareStatement("Insert into ProjectGroup Values(?,?,?,?)");
            	
            	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            	
            	while(true) {
            		System.out.print("Enter Student ID :");
            		int std_id = Integer.parseInt(br.readLine());
            		
            		System.out.print("Enter Student Name :");
            		String std_name = br.readLine();
            		
            		System.out.print("Enter Student Branch :");
            		String std_branch = br.readLine();
            		
            		System.out.print("Enter Student Section :");
            		int std_section = Integer.parseInt(br.readLine());
            		
            		
            		pstm.setInt(1, std_id);
            		pstm.setString(2, std_name);
            		pstm.setString(3, std_branch);
            		pstm.setInt(4, std_section);
            		
            		 count = pstm.executeUpdate();
            		
            		if(count>0) {
            			System.out.println(count +" record inserted");
            		}
            		else {
            			System.out.println("No Record inserted");
            		}
            		
            		System.out.println("Do you want to insert  more records[Yes/No]\n");
            		
            		String ch =br.readLine();
            		if(ch.equalsIgnoreCase("no")) {
            			break;
            		}
            		
            		
            	}

            } else {
                System.out.println("❌ Connection failed! Could not insert data.");
            }
        }
            catch (Exception e) {
//            e.printStackTrace();
        	System.out.print(e);
        }
    }
}
