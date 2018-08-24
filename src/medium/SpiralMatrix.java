package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    //递归，读取更小的matrix 不是正方形
    //错
//    public static List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> solution = new ArrayList<>();
//        if(matrix == null || matrix.length == 0) return solution;
//
//        int m = matrix[0].length;
//        int n = matrix.length;
//
//        //逐层剥洋葱式处理
//        int i = 0;
//        while ((m - 2 * i) <= 1 || (n - 2 * i) <= 1) {
//            for(int col = i, row = i; col < m - i; col++) { solution.add(matrix[row][col]); }
//            for(int col = m - i, row = i; row < n - i; row++) { solution.add(matrix[row][col]); }
//            for(int col = m - i, row = n - i; col > i; col--) { solution.add(matrix[row][col]); }
//            for(int col = i, row = n - i; row > i; row--) { solution.add(matrix[row][col]); }
//            i++;
//        }
//
//        //处理剩余的一行/一列/一个
//        if((n - 2 * i) == 1 && (m - 2 * i) == 1) solution.add(matrix[1 + n / 2][1 + m / 2]);
//        else if((n - 2 * i) == 1) {
//            for(int j = i; j < m - i; j++) {
//                solution.add(matrix[1 + n / 2][j]);
//            }
//        }
//        else if((m - 2 * i) == 1) {
//            for(int j = i; j < n - i; j++) {
//                solution.add(matrix[j][1 + m / 2]);
//            }
//        }
//        return solution;
//    }


    //
    public List < Integer > spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

}
