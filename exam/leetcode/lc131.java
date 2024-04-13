package exam.leetcode;

import java.util.*;

public class lc131 {


    static List<List<String>> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static LinkedList<String> path = new LinkedList<>();
    public static List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    public static void backtrack(String s, int index){
        // 是否回文
        if (index >= s.length()){
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length(); i++){
            if (isPalindrome(s, index, i)){
                path.add(s.substring(index, i + 1));
            }else{
                continue;
            }
            backtrack(s, i + 1);
            path.removeLast();
        }
    }

    public static boolean isPalindrome(String s, int start, int end){
        if (s == null || s.length() == 1) return true;
        while(start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res =new ArrayList<>();
        res = partition(s);
        System.out.println(res);
    }
}
