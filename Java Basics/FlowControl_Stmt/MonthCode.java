package Java_Fundamentals.FlowControl_Stmt;
import java.util.Scanner;

public class MonthCode {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Month Code :");
		
		int MCode = sc.nextInt();
		String output;
		
		switch(MCode) {
		case 1:
			output="January";
			break;
			
		case 2:
			output="February";
			break;
			
		case 3:
			output="March";
			break;
			
		case 4:
			output="April";
			break;
			
		case 5:
			output="May";
			break;
			
		case 6:
			output="June";
			break;
			
		case 7:
			output="July";
			break;
			
		case 8:
			output="August";
			break;
			
		case 9:
			output="September";
			break;
			
		case 10:
			output="Ocober";
			break;
			
		case 11:
			output="November";
			break;
			
		case 12:
			output="December";
			break;
			
			default:
				output ="Invalid Month ! \nPlease give valid input from ( 1 to 12)";
				
		}
		System.out.println("Output : "+output);
		sc.close();
	}

}
