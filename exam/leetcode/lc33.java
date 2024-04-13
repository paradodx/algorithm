package exam.leetcode;

public class lc33 {

    /*
    * 1. nums: 4 5 6 7 0 1 2 前半段更长
    * 2. nums: 4 5 6 0 1 2 3 后半段更长
    * */

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[l] == target) return l;
            else if (nums[r] == target) return r;
            if (nums[l] < nums[mid]){
                if (nums[l] < target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (target > nums[mid] && target < nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
