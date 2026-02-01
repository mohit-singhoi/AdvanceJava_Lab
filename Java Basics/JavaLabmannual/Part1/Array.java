import java.util.Scanner;
class Array{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter row size :");
        int row=sc.nextInt();
          System.out.print("Enter row size :");
        int col=sc.nextInt();
        int  arr[][] = new int[row][col];

        System.out.println("Enter Array Elements");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Print arr[0]\n");
         for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
               System.out.println("Arr[0] :"+arr[0]);
            }
        }
        // System.out.println("Arr[0] :"+arr[0]);
        sc.close();

    }
    
}