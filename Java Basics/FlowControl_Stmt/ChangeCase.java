package Java_Fundamentals.FlowControl_Stmt;
import java.util.Scanner;

public class ChangeCase {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Step 1: Read a character input
        System.out.print("Enter Character : ");
       char ch = sc.next().charAt(0);
        
//        String ch = sc.nextLine();
        
        // Step 2: Print input format
        System.out.println("input :" + ch);
        
        // Step 3: Check and convert case
        if (Character.isLowerCase(ch)) {
        	
            char upper = Character.toUpperCase(ch);
            System.out.println("output :" + ch + "->" + upper);
        } else if (Character.isUpperCase(ch)) {
            char lower = Character.toLowerCase(ch);
            System.out.println("output :" + ch + "->" + lower);
        } else {
            System.out.println("Invalid input! Please enter an alphabet.");
        }
        
        sc.close();
	}
	

}
