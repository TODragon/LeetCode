package medium;

public class UniquePaths {
    //每次right 或 down一步后可以递归至
    //m,n-1 或 m-1,n
    public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;

        return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
    }

    //这样有重复，如果用memo
    //另一方面，mn和nm是对称的，同解
    //O(mn) time O(mn) space
    public static int uniquePathsMemo(int m, int n) {
        if(m <=0 || n <=0) return 0;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {res[i][0] = 1;}
        for(int i = 1; i < n; i++) {res[0][i] = 1;}

        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++) {
                if(res[row][col] == 0) {
                    res[row][col] = res[row][col - 1] + res[row - 1][col];
                    if(row < n && col < m) res[col][row] = res[row][col];
                }
                else continue;
            }
        }
        return res[m - 1][n - 1];
    }

    public static void main(String args[]) {
        System.out.print(uniquePathsMemo(1, 2));
    }
}
