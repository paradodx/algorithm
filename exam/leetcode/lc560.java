package exam.leetcode;

public class lc560 {

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,1,1,1,1};
        int res = subarraySum(arr, 4);
        System.out.println(res);
    }
}
