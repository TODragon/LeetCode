package medium;

public class SearchA2DMatrixII {
    //忘了col有sorted
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for(int i = 0; i <= searchRow(matrix, target, 0, matrix.length - 1); i++) {
            if(searchCol(matrix, target, i, 0, matrix[i].length - 1)) return true;
        }
        return false;
    }

    private int searchRow(int[][] matrix, int target, int lo, int hi) {
        if(lo >= hi - 1) return hi;
        int mid = lo + (hi - lo) / 2;
        if(target == mid) return mid;
        else if(target > mid) return searchRow(matrix, target, mid, hi);
        else return searchRow(matrix, target, lo, mid);
    }

    private boolean searchCol(int[][] matrix, int target, int row, int lo, int hi) {
        if(lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if(target == matrix[row][mid]) return true;
        else if(target > matrix[row][mid]) return searchCol(matrix, target, row, mid + 1, hi);
        else return searchCol(matrix, target, row, lo, mid - 1);
    }


    //discuss
    //右上往左下
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
