package Java_Fundamentals.FlowControl_Stmt;

import java.util.Scanner;
public class GenderAge {
	public String interest(String gender, int age) {
		if ((gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("M"))  && (age >=1 && age<=58))

			return "8.4 % Interest";
		
		if ((gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("M"))  && (age >=59 && age<=100))
			return "10.5 % Interest";
		
		if ((gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("F"))  && (age >=1 && age<=58))

			return "8.2 % Interest";
		
		if ((gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("F"))  && (age >=59 && age<=100))
			return "9.2 % Interest";
		
        else
		return "Invalid Input";
	}
	
	public static void main(String[] args) {
		GenderAge g = new GenderAge();
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("Enter your Gender : ");
		 String s = sc.nextLine();
		 
		 System.out.print("Enter your Age : ");
		 int age = sc.nextInt();
		 System.out.println(g.interest(s,age));
		 
		 sc.close();
	}

}
