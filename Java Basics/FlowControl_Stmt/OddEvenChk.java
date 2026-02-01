package Java_Fundamentals.FlowControl_Stmt;

import java.util.Scanner;
public class OddEvenChk {
	public static String chkevenodd(int n) {
		if(n>1) {
			if(n%2==0) return "Even Number";
			else return "Odd Number";
		}
		else return "O, 1 is not  an Even or Not  an Odd Number";
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int n= sc.nextInt();
		System.out.print(OddEvenChk.chkevenodd(n));
	
		sc.close();
	}

}
