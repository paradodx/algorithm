package exam.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lc34 {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null) return new int[]{-1, -1};
        int count = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                if (!map.containsKey(nums[i])){
                    map.put(nums[i], i);
                }
                count++;
            }
        }
        if (map.containsKey(target)){
            return new int[]{map.get(target), map.get(target) + count};
        }
        return new int[]{-1, -1};
    }

    public static int[] searchRange2(int[] nums, int target){
        if (nums == null) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        int first = -1, last = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                first = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                last = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, 8);
        int[] res2 = searchRange2(nums, 8);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }
}
