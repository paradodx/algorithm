package exam.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc39 {

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, 0);
        return res;
    }

    public static void backtrack(int[] candidates, int index, int target, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target){
                break;
            }
            path.add(candidates[i]);
            backtrack(candidates, i, target, sum);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        List<List<Integer>> res = new ArrayList<>();
        res = combinationSum(nums, 8);
        System.out.println(res);
    }
}
