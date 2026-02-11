import java.util.Scanner;

public class CheckCharacter {

    public static void  CheckChar(char ch){
        if (Character.isDigit(ch)) {
            System.out.println("It is a Number.");
        } 
        else if (Character.isLetter(ch)) {
            System.out.println("It is an Alphabet.");
        } 
        else {
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
