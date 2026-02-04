package ClassLab.Threading;

class C implements Runnable {
    public synchronized void run() {
        for (int i = 0; i <=100; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}

public class Sync {
    public static void main(String[] args) {
        C b1 = new C();
        Thread t1 = new Thread(b1, "First");
        Thread t2 = new Thread(b1, "Second");

        try {
            t1.start();
            Thread.sleep(10000); // delay to see difference
            t2.start();
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
    }
}
