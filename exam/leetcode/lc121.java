package exam.leetcode;

public class lc121 {

    public static int maxProfit(int[] prices){
        if (prices == null || prices.length == 0)return 0;
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++){
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]),
                    dp[i - 1][3] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(Math.max(dp[n - 1][1], dp[n - 1][2]), dp[n - 1][3]);
    }

    public static int maxProfit2(int[] prices, int fee){
        if (prices == null || prices.length == 0)return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        // int[] prices = {1,2,3,0,2};
        int[] prices = {1, 3, 2, 8, 4, 9};
        int res = maxProfit2(prices, 2);
        System.out.println(res);
    }
}
