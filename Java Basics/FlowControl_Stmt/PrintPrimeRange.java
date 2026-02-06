import java.util.Scanner;

public class PrintPrimeRange {
    public static void PrintPrimeBwRange(int s, int e) {

        for (int i = s; i <= e; i++) {
            int count = 0;
            for(int j = 1;j<=i;j++){
                if(i % j == 0){
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Starting and Ending Point!");
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println("Prime Numbers");
        PrintPrimeBwRange(start,end);

        sc.close();
    }

}
