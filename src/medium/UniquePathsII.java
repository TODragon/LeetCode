package medium;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];

        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        res[m - 1][n - 1] = 1;
        // last col
        for(int i = m - 2; i >= 0; i--) {
            res[i][n - 1] = (obstacleGrid[i][n - 1] == 1)? 0: res[i + 1][n - 1];
        }
        //last row
        for(int i = n - 2; i >= 0; i--) {
            res[m - 1][i] = (obstacleGrid[m - 1][i] == 1)? 0: res[m - 1][i + 1];
        }

        for(int row = m - 2; row >= 0; row--) {
            for(int col = n - 2; col >= 0; col--) {
                res[row][col] = (obstacleGrid[row][col] == 1)? 0: res[row + 1][col] + res[row][col + 1];
            }
        }
        return res[0][0];
    }
}
