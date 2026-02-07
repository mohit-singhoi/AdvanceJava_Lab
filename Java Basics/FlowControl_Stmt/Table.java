import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Table Number to Print Table :");
        int n = sc.nextInt();
        PrintTable(n);
        sc.close();
    }

    public static void PrintTable(int n){
        int table =0;
        for(int i=1;i<=10;i++){
            table = n*i;
            System.out.println(n + " X " + i + " = " + table);
        }
    }

    
}
