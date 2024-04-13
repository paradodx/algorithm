package exam.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc438 {

    public static List<Integer> findAnagrams(String s, String p) {
        // 定义返回数组和表示26个字母出现频率的数组
        List<Integer> res = new ArrayList<>();
        int[] sc = new int[26];
        int[] pc = new int[26];
        if (s.length() < p.length()){
            return res;
        }
        // 遍历p数组，加入到频率数组中
        for (int i = 0; i < p.length(); i++){
            pc[p.charAt(i) - 'a']++;
        }
        // 设置left、right遍历s数组
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            // right向后滑动，滑到的元素在s频率数组中的频率+1
            int cur = s.charAt(right) - 'a';
            sc[cur]++;
            // 比较其与p频率数组的频率大小
            // 如果大于p 则让left滑到的元素在s频率数组频率-1，left后移
            while(sc[cur] > pc[cur]){
                sc[s.charAt(left) - 'a']--;
                left++;
            }
            // 如果小于p，则继续向后遍历, right向后滑动的过程中如果滑动长度与p相等，则表示找到字串，加入结果
            if(right - left + 1 == p.length()){
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res = new ArrayList<>();
        res = findAnagrams(s, p);
        System.out.println(res);
    }
}
