package medium;

public class SearchA2DMatrix {

    //分别对行列二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = searchRow(matrix, target, 0, matrix.length - 1);
        int col = searchCol(matrix, target, row, 0, matrix[0].length - 1);
        System.out.print(row + "" + col);
        if(target == matrix[row][col]) return true;

        return false;
    }

    private static int searchRow(int[][] matrix, int target, int low, int hi) {
        if(hi - low <= 1) {
            if(target < matrix[hi][0]) return low;
            else return hi;
        }

        int mid = low + (hi - low) / 2;
        if(target > matrix[mid][0]) return searchRow(matrix, target, mid, hi);
        else if(target < matrix[mid][0]) return searchRow(matrix, target, low, mid);
        else return mid;
    }

    private static int searchCol(int[][] matrix, int target, int row, int low, int hi) {
        if(hi - low <= 1) {
            if(target < matrix[row][hi]) return low;
            else return hi;
        }

        int mid = low + (hi - low) / 2;
        if(target > matrix[row][mid]) return searchCol(matrix, target, row, mid, hi);
        else if(target < matrix[row][mid]) return searchCol(matrix, target, row, low, mid);
        else return mid;
    }


    public static void main(String args[]) {
        int[][] matrix = {};
        System.out.print(searchMatrix(matrix, 2));
    }
}
