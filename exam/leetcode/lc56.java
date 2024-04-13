package exam.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc56 {

    public static int[][] merge(int[][] arr){
        if (arr == null || arr.length < 2){
            return arr;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            int left = arr[i][0];
            int right = arr[i][1];
            if (res.size() == 0 || res.get((res.size() - 1))[1] < left){
                res.add(new int[]{left, right});
            }else {
                res.get((res.size() - 1))[1] = Math.max(right, res.get((res.size() - 1))[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new int[arr.length][];
        res = merge(arr);
        System.out.println(Arrays.deepToString(res));
    }
}
