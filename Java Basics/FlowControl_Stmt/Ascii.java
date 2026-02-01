package Java_Fundamentals.FlowControl_Stmt;

import java.util.Scanner;
public class Ascii {
public  String characterrange(char c) {
	if (c>=48 && c<=57)
		return "Digit";
	
	else if( (c>=65 && c<=90) || (c>=97 && c<=122))
		return "Alphabet";
	
	else
		return "Special Character";
}

public static void main(String[] args) {
	Ascii a = new Ascii();
	
//	  Ascii a = new Ascii();
//      System.out.println("Given Character is : " + a.characterrange('8'));
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter Any Character : ");
	char c = sc.next().charAt(0); 
	System.out.println("Given Charcter is : "+a.characterrange(c));
	
	sc.close();
}
}
