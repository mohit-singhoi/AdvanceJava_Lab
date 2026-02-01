package wipro;

import java.util.Scanner;

public class ClientInsert {
	public static void main(String[] args) {
		int id;
		String name;
		int salary;
		int deptno;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		id= Integer.parseInt(sc.nextLine());
		System.out.println("Enter the name");
		name = sc.nextLine();
		System.out.println("Enter the salary");
		salary= Integer.parseInt(sc.nextLine());
		System.out.println("Enter dept no");
		deptno= Integer.parseInt(sc.nextLine());
		
		EmpBean e = new EmpBean();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		e.setDeptno(deptno);
		
		EmpDAO dao = new EmpDAO();
		
		if(dao.insertEmpDetails(e))
		{
			System.out.println("Successfully inserted");
		}
		else
		{
			System.out.println("Failll");
		}
		sc.close();
	}
	


}
