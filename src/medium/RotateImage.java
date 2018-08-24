package medium;

public class RotateImage {
    //二维矩阵右旋90度
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n < 2) return;

        //分奇偶
        //可以通过+1 来简化
        if(n % 2 == 0) {
            for(int i = 0; i < n / 2; i++) {
                for(int j = 0; j < n / 2; j++) {
                    exch(matrix, i, j);
                }
            }
        }
        else {
            for(int i = 0; i < n / 2; i++) {
                for(int j = 0; j <= n / 2; j++) {
                    exch(matrix, i , j);
                }
            }
        }
    }
    //使用一个四旋的交换函数，遍历1/4即可
    //i,j==j,n-1-i==n-1-i,n-1-j==n-1-j,i
    public void exch(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        int n = matrix.length;
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 -i];
        matrix[j][n - 1 -i] = temp;
    }



    //jiuzhang solution
    public void rotate3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int length = matrix.length;

        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length -j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
        }
    }
    public void rotate2(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        for (int r = 0; r < (n + 1) / 2; r++) {
            for (int c = 0; c < n / 2; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n - 1 - c][r];
                matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
                matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
                matrix[c][n - 1 - r] = tmp;
            }
        }
    }


    public void rotate1(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < n; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n - r - 1][c];
                matrix[n - r - 1][c] = tmp;
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }
    }
}
