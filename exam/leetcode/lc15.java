package exam.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) return res;
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new ArrayList<>();
        res = threeSum(nums);
        System.out.println(res);
    }
}
