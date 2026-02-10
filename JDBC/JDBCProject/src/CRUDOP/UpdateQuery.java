package CRUDOP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JDBCUtil.JDBCUtil1;

public class UpdateQuery {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Scanner sc = new Scanner(System.in);
		
		try {
		connection = JDBCUtil1.getJdbcConnection();
		
		if(connection !=null) {
			String mysqlQuery = "update student set age =? where id =?";
			
			preparedstatement = connection.prepareStatement(mysqlQuery);
			
				
			// Setting values into preparedStstement
			if (preparedstatement != null) {
				System.out.print("Enter the id which you want to update : ");
				int id = sc.nextInt();

				System.out.print("Enter your Updated Age: ");
				int age = sc.nextInt();

				preparedstatement.setInt(1, age);
				preparedstatement.setInt(2, id);

				int rows = preparedstatement.executeUpdate();

				if (rows > 0) {
				    System.out.println("✅ Record updated successfully");
				} else {
				    System.out.println("❌ No record found with this id");
				}

			}
			

		}
			
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil1.closeResources(connection, preparedstatement,resultset);
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
