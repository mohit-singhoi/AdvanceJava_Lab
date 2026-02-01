package Java_Fundamentals.FlowControl_Stmt;
import java.util.Scanner;

public class PrintEvenRange {
	static void  PrintEven(int a, int b) {
		
		for(int i=a;i<=b;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter range From :");
			int f=sc.nextInt();
			
			System.out.print("Enter range To :");
			int t=sc.nextInt();
			
			PrintEven(f,t);
		
			sc.close();
			
			
			
		
	}

}
