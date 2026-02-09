import java.util.Scanner;

public class Vote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, Chcek User is Eligible for Vote or Not");
        System.out.print("Enter your Age : ");
        int age = sc.nextInt();
        checkEligible(age);
        sc.close();
    }

    public static void checkEligible(int age){
        if(age>0 && age<=150){
            if(age>=18){
                System.out.println("Congrets,\nYou Are  Eligible to Vote.");
            }else{
                System.out.println("You age Under 18,\nThat's reason you are Not Eligible to Vote.");
            }
        }else{
            System.out.println("Invalid Age,\nPlease Enter valid Age.");
        }
    }
}