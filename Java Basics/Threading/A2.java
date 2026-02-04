package ClassLab.Threading;



class A1 implements Runnable
{
	public void run() {
		System.out.println("Statement is running");
	}
}

public class A2 {
	public static void main(String[] args) {
		A1 a1 = new A1();
		Thread t = new Thread(a1);
		t.start();

	}	

}
