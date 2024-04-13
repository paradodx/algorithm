package exam.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class lc78 {

    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subset(int[] nums){
        backtrack(nums, 0);
        return res;
    }

    public static void backtrack(int[] nums, int start){
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        res = subset(nums);
        System.out.println(res);
    }
}
