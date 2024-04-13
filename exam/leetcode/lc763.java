package exam.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc763 {

    public static List<Integer> partitionLabels(String s){
        int[] list = new int[26];
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            list[s.charAt(i) - 'a'] = i;
        }
        int index = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++){
            index = Math.max(index, list[s.charAt(i) - 'a']);
            if (i == index){
                res.add(index - last);
                last = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = new ArrayList<>();
        res = partitionLabels(s);
        System.out.println(res);
    }
}
