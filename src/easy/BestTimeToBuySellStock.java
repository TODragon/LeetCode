package easy;

public class BestTimeToBuySellStock {

    //n^2
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = prices.length - 1; i > 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                max = Math.max(max, prices[i] - prices[j]);
            }
        }
        return max;
    }

    //jiuzhang solution
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;  //just remember the smallest price
        int profit = 0;
        for (int i : prices) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }

        return profit;
    }
}
