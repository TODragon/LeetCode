package medium;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;

        for(int i = 0; i < n / 2; i++) {
            int row = i;
            int col = i;
            while(col < n - 1 - i) {
                matrix[row][col] = num;
                num++;
                col++;
            }
            while (row < n - 1 - i) {
                matrix[row][col] = num;
                num++;
                row++;
            }
            while (col > i) {
                matrix[row][col] = num;
                num++;
                col--;
            }
            while (row > i) {
                matrix[row][col] = num;
                num++;
                row--;
            }
        }
        if(n % 2 != 0) matrix[n / 2][n / 2] = num;
        return matrix;
    }

    public static void main(String args[]) {
        int[][] a = generateMatrix(3);
        for(int[] i: a) {
            for(int j: i) {
                System.out.print(j + "     ");
            }
            System.out.println("");
        }
    }
}
