package CRUDOP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import JDBCUtil.JDBCUtil;

public class InsertQuery {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		
		try {
		connection =	JDBCUtil.getJdbcConnection();
		
		if(connection !=null) {
			statement = connection.createStatement();
			String myinsertQuery = "insert into student(name, roll, age) values('Vinay Kaushik',2,23)";
			
			int roweffected = statement.executeUpdate(myinsertQuery);
			
			if(roweffected ==1) {
				System.out.println("Row Successfully Inserted");
			}else {
				System.out.println("Row Not Inserted");
			}
		}
			
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeResources(connection, statement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
