package exam.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc22 {

    static List<String> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return res;
    }

    public static void backtrack(int max, int left, int right){
        if (left == max && right == max){
            res.add(sb.toString());
        }
        if (left < max) {
            sb.append('(');
            backtrack(max, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backtrack(max, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        res = generateParenthesis(3);
        System.out.println(res);
    }
}
