package Java_Fundamentals.FlowControl_Stmt;

public class NumberCheck {
	public String num(int a) {
		if(a ==0 ) return "Zero";
		else if(a >0 ) return "Positive";
			
		
		else return "Negative";
	}
	
	public static void main(String[] args) {
		NumberCheck nc = new NumberCheck();
		System.out.println("Result(0) :"+nc.num(0));
		System.out.println("Result(5) :"+nc.num(5));
		System.out.println("Result(-5) :"+nc.num(-5));
	}

}
