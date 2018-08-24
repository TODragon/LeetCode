package medium;

import java.util.Arrays;

public class PerfectSquares {
    //使用Memo记录每个数的least number， 直接取出
    //1.2.3.4...
    //1.2.3.1...
    //再计算该数由哪两个数求和得到，遍历取最小
    public static int numSquares(int n) {
        if(n == 1) return 1;
        int[] res = new int[n];
        res[0] = 1;

        for(int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        for(int i = 1; i * i <= n; i++) {
            res[i * i - 1] = 1;
        }

        for(int i = 1; i < n; i++) {
            int min = res[i]; //必然可以有n个1组成
            int left = 0;
            int right = i - 1;

            while(left <= right) {
                int temp = res[left] + res[right];
                min = (min < temp)? min: temp;
                left++;
                right--;
            }
            res[i] = Math.min(min, res[i]);
        }

        return res[n - 1];
    }

    //jiuzhang solution
    public int numSquares1(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }


    public int numSquares2(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i)
            dp[i * i] = 1;

        for (int i = 0; i <= n; ++i)
            for (int j = 0; i + j * j <= n; ++j)
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

        return dp[n];
    }

    public int numSquares3(int n) {
        // Write your code here
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i <= n; ++i) {
            int j = (int)Math.sqrt(n * 1.0 - i * i);
            if (i * i + j * j == n) {
                int res = 0;
                if (i > 0)
                    res += 1;
                if (j > 0)
                    res += 1;
                return res;
            }
        }
        return 3;
    }

    public static void main(String args[]) {
        for(int i = 1; i <20; i++) {
            System.out.print(numSquares(i) + "==");
        }
        System.out.print("\n");
        for(int i = 1; i <20; i++) {
            System.out.print(i + "==");
        }

    }
}
