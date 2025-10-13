import java.util.Scanner;

class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = sc.nextInt();
        int count = 0;

        // 0 and 1 are not prime
        if (n < 2) {
            System.out.println(n + " is NOT a Prime Number");
            return;
        }

        // check divisibility from 1 to n
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }

        // a prime number has exactly 2 factors (1 and itself)
        if (count == 2)
            System.out.println(n + " is a Prime Number");
        else
            System.out.println(n + " is NOT a Prime Number");

        sc.close();
    }
}
