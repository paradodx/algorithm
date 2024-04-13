package exam.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc17 {

    static List<String> res = new ArrayList<>();

    public static List<String> letterComb(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        HashMap<Character, String> phone = new HashMap<>();

        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");
        backtrack(digits, phone, 0);
        return res;
    }

    static StringBuilder sb = new StringBuilder();
    public static void backtrack(String digits, HashMap<Character, String> phone, int num) {
        if (num == digits.length()){
            res.add(sb.toString());
        }else {
            String str = phone.get(digits.charAt(num));
            for (int i = 0; i < str.length(); i++){
                sb.append(str.charAt(i));
                backtrack(digits, phone, num + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = new ArrayList<>();
        res = letterComb(digits);
        System.out.println(res);
    }
}
