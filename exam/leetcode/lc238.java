package test;

import java.util.Arrays;

public class lc238 {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int s = 1;
        for (int i = 0; i < nums.length; i++){
            res[i] = 1;
            res[i] *= s;
            s *= nums[i];
        }
        s = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            res[i] *= s;
            s *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] nums2 = {1,2,3,4};
        nums = productExceptSelf(nums);
        nums2 = productExceptSelf(nums2);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
    }
}
