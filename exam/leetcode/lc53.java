package exam.leetcode;

public class lc53 {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0){
                sum = 0;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }
}
