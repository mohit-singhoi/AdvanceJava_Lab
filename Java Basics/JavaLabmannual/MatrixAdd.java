public class MatrixAdd {
    public static int[][] MatrixAddition(int a[][], int b[][]){
        int row = a.length;
        int col = a[0].length;

        int add [][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                add[i][j] = a[i][j]+b[i][j];
            }
        }
        return add;
    }
    public static void print(int add[][]){
        for(int i=0;i<add.length;i++){
            for(int j=0;j<add[0].length;j++){
                System.out.print(add[i][j]+" ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        int a[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int b[][] = {{1,2,3},{4,5,6},{7,8,9}};

        int result[][] = MatrixAddition(a, b);
        print(result);
    }
    
}
