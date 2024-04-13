package exam.leetcode;

public class lc55_45 {

    public static boolean canJump(int[] nums){
        if (nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++){
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }

    public static int jump(int[] nums){
        if (nums== null || nums.length == 0 || nums.length == 1) return 0;
        int maxCover = 0, curCover = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            maxCover = Math.max(maxCover, i + nums[i]);
            if (maxCover >= nums.length - 1){
                count++;
                break;
            }
            if (i == curCover){
                curCover = maxCover;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,1,4};
        boolean res = canJump(nums);
        int skip = jump(nums);
        System.out.println(res);
        System.out.println(skip);
    }
}
