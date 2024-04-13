package exam.leetcode;

public class lc474 {

    public static int findMax(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs){
            int zero = 0;
            int one = 0;
            for (char c : str.toCharArray()){
                if (c == '0') zero++;
                else one++;
            }
            for (int i = m; i >= zero; i--){
                for(int j = n; j>= one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
