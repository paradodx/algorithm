package exam.leetcode;

import java.util.Arrays;

public class lc322_279_518 {

    public static int coin(int[] coins, int amount){
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++){
            dp[i] = max;
        }
        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                if (dp[j - coins[i]] != max){
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static int coin2(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }


    public static int numSquares(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++){
            for (int j = i * i; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        int res = numSquares(n);
        // System.out.println(res);

        int[] coins = {1,2,5};
        int res2 = coin2(coins, 5);
        System.out.println(res2);
    }
}
