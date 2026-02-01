package Java_Fundamentals.FlowControl_Stmt;

public class Alphabetical {
	
	public String alphabetical(char a, char b) {
		if(a<b)
		return a +" , "+b;
		else if( a>b)
			return b +" , "+a;
		else
			return "Both are same character " +b;
	}
	
	public static void main(String[] args)
	{
		Alphabetical a= new Alphabetical();
		System.out.println(a.alphabetical('c','p'));
		System.out.println(a.alphabetical('z','p'));
		System.out.println(a.alphabetical('c','a'));
	}
	

}
