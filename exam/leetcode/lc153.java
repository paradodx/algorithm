package exam.leetcode;

import com.sun.tools.javac.Main;

public class lc153 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] <= nums[mid]) {
                min = Math.min(nums[l], min);
                l = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                r = mid - 1;
            }
        }
        return min;
    }

    public static int findMax(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] <= nums[mid]) {
                max = Math.max(nums[mid], max);
                l = mid + 1;
            } else {
                max = Math.max(nums[l], max);
                r = mid - 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,0,1,2};
        int min = findMin(nums);
        System.out.println(min);

        int max = findMax(nums);
        System.out.println(max);
    }
}
