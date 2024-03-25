package test;

import java.util.*;

/*
 * 测试
 * */
public class lc49 {
    public static List<List<String>> group(String[] str){
        if(str == null){
            return null;
        }
        HashMap<String, List<String>> ans = new HashMap<>();
        for (String s : str){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = ans.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            ans.put(key, list);
        }
        return new ArrayList<List<String>>(ans.values());
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = new ArrayList<>();
        ans = group(arr);
        System.out.println(ans);

        String[] arr2 = {""};
        List<List<String>> ans2 = new ArrayList<>();
        ans2 = group(arr2);
        System.out.println(ans2);
    }
}
