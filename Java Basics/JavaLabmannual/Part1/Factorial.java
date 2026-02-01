import java.util.Scanner;
public class Factorial{
    public int fact(int n){
        if(n==1 || n==0){
        return 1;
        }
    
    else
    return n*fact(n-1);
    }
    //Main Function
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any Nmber :");
        int num= sc.nextInt();
        Factorial f = new Factorial();
        int result = f.fact(num);
        System.out.println("factorial of " +num+ " is : " +result);
        sc.close();
    }
   
}