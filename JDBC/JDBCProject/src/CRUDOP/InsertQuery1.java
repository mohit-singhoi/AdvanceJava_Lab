package CRUDOP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCUtil.JDBCUtil;

public class InsertQuery1 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		
		try {
		connection = JDBCUtil.getJdbcConnection();
		
		if(connection !=null) {
			String mysqlQuery = "insert into student(name, roll, age) values (?,?,?)";
			
			preparedstatement = connection.prepareStatement(mysqlQuery);
			
			
			// Insert By User level  Type:1
			Scanner sc = new Scanner(System.in);
			
			// Taking input from user
			System.out.print("Enter your Name: ");
			String name = sc.nextLine();

			System.out.print("Enter your Roll: ");
			int roll = sc.nextInt();

			System.out.print("Enter your Age: ");
			int age = sc.nextInt();
			
			// Setting values into preparedStstement
			if (preparedstatement != null) {
			    preparedstatement.setString(1, name);
			    preparedstatement.setInt(2, roll);
			    preparedstatement.setInt(3, age);

			    int rows = preparedstatement.executeUpdate();
			    System.out.println(rows + " record inserted successfully ✅");
			}
			sc.close();

			
//			// Already Inserted at the time of Writing Code Type : 2
//			if(preparedstatement!=null) {
//			preparedstatement.setString(1,"Abhinav");
//			preparedstatement.setInt(2,23);
//			preparedstatement.setInt(3,24);
//			
//			
//			int roweffected = preparedstatement.executeUpdate();
//			
//			if(roweffected == 1) {
//				System.out.println("1 Row Inserted Successfully");
//			}else {
//				System.out.println("Row Not Successfully");
//			
//			}
//			
//			}
			

		}
			
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeResources(connection, preparedstatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
