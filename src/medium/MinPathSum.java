package medium;

public class MinPathSum {
    //简单的使用递归
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        return grid[0][0] + Math.min(minPathSum(grid, m - 1, n), minPathSum(grid, m, n - 1));
    }

    public int minPathSum(int[][] grid, int m, int n) {

        return 0;
    }

    //使用memo
    public int minPathSumMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        res[m - 1][n - 1] = grid[m - 1][n - 1];

        for(int row = m - 2; row >= 0; row--) {
            res[row][n - 1] = grid[row][n - 1] + res[row + 1][n - 1];
        }

        for(int col = n - 2; col >= 0; col--) {
            res[m - 1][col] = grid[m - 1][col] + res[m - 1][col + 1];
        }

        for(int row = m - 2; row >= 0; row--) {
            for(int col = n - 2; col >= 0; col--) {
                res[row][col] = grid[row][col] + Math.min(res[row + 1][col], res[row][col + 1]);
            }
        }

        return res[0][0];
    }
    //还可以不用额外的space inplace
}
