////Problem 1: A java program to find out whether entered integer is prime or not using command line arguments.


package JavaLabmannual;

//public class PrimeCheck_01 {
//    public static void main(String[] args) {
//        // Check if the user entered a command line argument
//        if (args.length == 0) {
//            System.out.println("Please provide an integer as a command line argument.");
//            return;
//        }
//
//        // Convert the first argument to an integer
//        int num = Integer.parseInt(args[0]);
//        boolean isPrime = true;
//
//        // Handle numbers less than 2
//        if (num < 2) {
//            isPrime = false;
//        } else {
//            // Check divisibility from 2 to num/2
//            for (int i = 2; i <= num / 2; i++) {
//                if (num % i == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//        }
//
//        // Output result
//        if (isPrime)
//            System.out.println(num + " is a Prime number.");
//        else
//            System.out.println(num + " is NOT a Prime number.");
//    }
//}



//////2
import java.util.Scanner;

class PrimeCheck_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = sc.nextInt();
        int count = 0;

   
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


