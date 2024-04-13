package exam.leetcode;

import java.util.HashMap;

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

    public static int sub(int[] nums, int k){
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            pre += nums[i];
            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }else {
                map.put(pre, map.getOrDefault(pre, 0) + 1);
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
