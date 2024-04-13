package exam.leetcode;

import java.util.HashSet;

public class lc03 {

    public static int lengthOfLongestSubstring(String s) {
        // 定义set, i = 0, j = 0
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int max = 0, cur = 0;
        char[] chars = s.toCharArray();
        // j < s.length下, 判断set中是否有j对应的元素
        while(j < s.length()){
            // 没有: 添加j对应的元素进set, j++
            if(!set.contains(chars[j])){
                set.add(chars[j]);
                j++;
                cur++;
                max = Math.max(max, cur);
            }else {
                // 有: 删去set中i对应的元素, i++, 再次判断是否有j对应的元素
                set.remove(chars[i]);
                i++;
                cur--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "abcbacdca";
        int res = lengthOfLongestSubstring(s);
        int res2 = lengthOfLongestSubstring(s2);
        System.out.println(res);
        System.out.println(res2);
    }
}
