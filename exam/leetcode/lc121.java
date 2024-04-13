package exam.leetcode;

public class lc121 {

    // 只能买卖一次股票
    public static int maxProfit(int[] prices){
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i <prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    // 多次买卖股票
    public static int maxProfit2(int[] prices){
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    // 2次买卖股票
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

    // k次买卖股票
    public static int maxProfit4(int[] prices, int k) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2){
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++){
            for (int j = 0; j < k * 2 - 1; j += 2){
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }


    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        int[] prices = {3,3,5,0,0,3,1,4};
        int res = maxProfit4(prices, 2);
        System.out.println(res);
    }
}
