// WAP to print the sum of digit of a given Number.
public class DigitSum {

    public static int digitSum(int n){
        int sum =0;
        while(n>0){
            //int num = n;
         
            int r = n%10;
            sum = sum+r;
            n=n/10;
            
        }
        return sum;
    }

    //Main function
    public static void main(String[] args) {
        int n = 125;
       int result = digitSum(n);
       System.out.println("Sum of Digit : " +result);

    }
}

