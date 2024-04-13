package exam.leetcode;

public class lc377 {

    public static int combination(int[] nums, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;
            for (int j = 0; j <= target; j++){
                for (int i = 0; i < nums.length; i++){
                    if (j - nums[i] >= 0) dp[j] += dp[j - nums[i]];
                }
            }

        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int res = combination(nums, 4);
        System.out.println(res);
    }
}
