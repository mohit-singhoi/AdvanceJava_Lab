import java.util.Scanner;

public class TableInRange {

    public static void PrintRangeTable(int start , int end){
        int s = start;
        int e = end;
        int table =0;


        for(int i = s;i<=e;i++){
            for(int j =1;j<=10;j++){
                table = i*j;
                System.out.println(i + " X " + j + " = " + table);
            }
            System.out.println("\t");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Starting Point : ");
        int s = sc.nextInt();
        System.out.println("Enter the Ending Point  :");
        int e = sc.nextInt();
        PrintRangeTable(s, e);
    }
    
}
