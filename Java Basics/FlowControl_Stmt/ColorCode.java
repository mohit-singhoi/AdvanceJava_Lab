package Java_Fundamentals.FlowControl_Stmt;
import java.util.Scanner;
public class ColorCode {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Color Code :");
		
		char code = sc.next().charAt(0);
		
		code = Character.toUpperCase(code);
		
		System.out.println("Input :" +code);
		
		String color;
		switch (code) {
		case 'R':
			color = "Red";
			break;
			
			case 'B':
				color ="Black";
				break;
				
			case 'G':
				color = "Green";
				break;
				
			case 'O':
				color = "Orange";
				break;
				
			case 'Y':
				color ="Yellow";
				break;
				
			case 'W':
				color ="White";
				break;
				
				default:
					color ="Invalid Code";
		}
		
		System.out.println("Output : "+color);
		sc.close();
		
	}

}
