package CRUDOP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import JDBCUtil.JDBCUtil1;


public class SelectQuery {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset =null;
		Scanner sc = new Scanner(System.in);
		
		try {
		connection = JDBCUtil1.getJdbcConnection();
		
		if(connection !=null) {
			String mysqlQuery = "select * from student where id =?";
			preparedstatement = connection.prepareStatement(mysqlQuery);
			
			if(preparedstatement!=null) {
				System.out.print("Enter the Roll which you want to get from Database :");
				int id = sc.nextInt();
				preparedstatement.setInt(1, id);
				
				resultset=preparedstatement.executeQuery();
				
				if(resultset!=null) {
					
					if(resultset.next()) {
						System.out.println("ID\tNAME\tROLL\tAGE");
						System.out.println();
						System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getInt(4));
						
					}else {
						System.out.println("No Record Found for this ID");
					}
				}
			}
			
		


		}
			
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil1.closeResources(connection, preparedstatement, resultset);
				sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
