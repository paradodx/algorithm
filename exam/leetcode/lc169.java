package test;

import java.util.HashSet;
import java.util.Set;

public class lc169 {

    public static int majorElem(int[] nums){
        int count = 0;
        Integer cur = null;
        for (int num : nums){
            if (count == 0){
                cur = num;
            }
            if(cur == num){
                count++;
            }else {
                count--;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 1, 1, 3, 3, 2, 1, 1};
        int major = majorElem(arr);
        System.out.println(major);
    }
}
