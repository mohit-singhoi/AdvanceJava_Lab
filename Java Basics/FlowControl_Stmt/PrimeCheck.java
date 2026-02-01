package Java_Fundamentals.FlowControl_Stmt;
import java.util.Scanner;


public class PrimeCheck {
	public void  CheckPrime(int n) {
		int count=0;
		if(n==1 || n==0) {
			System.out.print(n + " is nor Prime and not Composit Number");
		return;
	}
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				count++;
			}
		}
		if(count==2)
			System.out.print(n + " is Prime Number");
		else
			System.out.print(n + " is not Prime number");
		
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the Number :");
		int num=sc.nextInt();
		
		PrimeCheck p = new PrimeCheck();
		p.CheckPrime(num);
		sc.close();
		
		
	}
	

}
