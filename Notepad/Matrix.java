import java.util.Scanner;

class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter row size: ");
        int row = sc.nextInt();
        System.out.print("Enter column size: ");
        int col = sc.nextInt();

        int m1[][] = new int[row][col];
        int m2[][] = new int[row][col];
        int m3[][] = new int[row][col];

        System.out.println("\nEnter the elements of 1st Matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m1[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nEnter the elements of 2nd Matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m2[i][j] = sc.nextInt();
            }
        }

        // Matrix Addition
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        System.out.println("\nResultant  after Matrix Addition:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }


if(row==col){
      // Matrix Multiplication

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

             for(int k=0;k<col;k++){
              m3[i][j]=0;
                m3[i][j] = m1[i][j] +m1[i][k]*m2[k][j];
            }
        }
}

        System.out.println("\n\nResultant  after Matrix Multiplication:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
}
else
System.out.println("\n\nInvalid Input please try again!");
    }
}
