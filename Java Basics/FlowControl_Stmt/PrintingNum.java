package Java_Fundamentals.FlowControl_Stmt;
import java.util.Scanner;

public class PrintingNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Range :");
		int n= sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.print(i+" ");
		}
		sc.close();
		
	}

}
