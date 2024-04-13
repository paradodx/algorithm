package exam.leetcode;

import java.util.Arrays;

public class lc674 {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int findLengthOfLCIS(int[] nums) {
        int res = 1, max = 1;;
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] < nums[i]){
                max++;
            }else {
                max = 1;
            }
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int res = findLengthOfLCIS(nums);
        System.out.println(res);
    }
}
