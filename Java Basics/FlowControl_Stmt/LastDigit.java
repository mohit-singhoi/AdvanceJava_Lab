package Java_Fundamentals.FlowControl_Stmt;

import java.util.Scanner;
public  class LastDigit {
	public static boolean lastdigitchk(int a,int b) {
		if(a>0 && b>0) {
			int r1 = a%10;
			int r2 = b%10;
			if(r1 == r2) {
				return true;
			}
			else return false;
		}
		else return false;
		
	}
	public static  void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter two Non-Negative Number : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.println(LastDigit.lastdigitchk(n1,n2));
		sc.close();
	}

}
