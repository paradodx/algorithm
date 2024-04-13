package exam.leetcode;

public class lc198 {

    public static int rob(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static int rob2(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int rob_1 = subRob(nums, 0, nums.length - 2);
        int rob_2 = subRob(nums, 1, nums.length - 1);
        return Math.max(rob_1, rob_2);
    }

    public static int subRob(int[] nums, int start, int end){
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start + 1]);
        for (int i = start + 2; i <= end; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int res = rob(nums);
        int res2 = rob2(nums);
        System.out.println(res2);
    }
}
