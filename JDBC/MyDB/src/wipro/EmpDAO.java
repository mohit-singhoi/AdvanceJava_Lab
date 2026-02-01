package wipro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	public boolean delete(int eid)
	{
		try {
			Connection con=JDBCCon.getConn();
			PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1, eid);
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(int eid, String nm, int sal, int dno)
	{
		try {
			Connection con=JDBCCon.getConn();
			PreparedStatement ps=con.prepareStatement("update employee set name=?, salary=?, deptno=? where id=?");
			ps.setString(1, nm);
			ps.setInt(2,  sal);
			ps.setInt(3, dno);
			ps.setInt(4, eid);
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<EmpBean> view()
	{
		List<EmpBean> list=new ArrayList<EmpBean>();
		try {
			Connection con=JDBCCon.getConn();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
						
			while(rs.next())
			{
				EmpBean e = new EmpBean();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getInt("salary"));
				e.setDeptno(rs.getInt("deptno"));
				list.add(e);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public EmpBean view(int id)
	{
		EmpBean e = new EmpBean();
		try {
			Connection con=JDBCCon.getConn();
			PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
						
			while(rs.next())
			{
				
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getInt("salary"));
				e.setDeptno(rs.getInt("deptno"));
				
			}
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return e;
		
		
	}	
	
	
	public boolean insertEmpDetails(EmpBean e)
	{
		try {
			Connection con=JDBCCon.getConn();
			PreparedStatement ps= con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getSalary());
			ps.setInt(4, e.getDeptno());
			int i = ps.executeUpdate();
			if(i>0)
				return true;
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return false;
		
	}


}
