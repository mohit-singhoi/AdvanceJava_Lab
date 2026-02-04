package ClassLab.Threading;


class B extends Thread
{
	public void run() {
		System.out.println("Statement is running");
	}
}

public class A {
	public static void main(String[] args) {
		B b1 = new B();
		Thread t = new Thread();
		b1.start();
//		t.getName()
		t.setName("Galgotias University(IIT Dankaur)");
		System.out.println("Name    "+ t);
	}

}
