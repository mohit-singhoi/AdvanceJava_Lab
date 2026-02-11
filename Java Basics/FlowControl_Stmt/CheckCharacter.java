import java.util.Scanner;

public class CheckCharacter {

    public static void  CheckChar(char ch){

        // //1st 
        // if (Character.isDigit(ch)) {
        //     System.out.println("It is a Number.");
        // } 
        // else if (Character.isLetter(ch)) {
        //     System.out.println("It is an Alphabet.");
        // } 
        // else {
        //     System.out.println("It is a Special Character.");
        // }

        //2nd
        if(ch>=48 && ch<=57){
            System.out.println("It is Number");
        }
        else if(ch>=65 && ch<=90 || ch>=97 && ch<=122){
            System.out.println("It is Character.");
        }
        else{
            System.out.println("It is a Special Character.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);
        CheckChar(ch);

        sc.close();
    }
}
