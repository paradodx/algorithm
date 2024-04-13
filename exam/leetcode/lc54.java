package exam.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        // 定义返回值数组和上下左右边界
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        // 上下左右边界都相等的时候遍历最后（最中间）一行
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) break;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return res;
    }

    public static List<Integer> zero(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while(true){
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
            for (int i = left; i <= right; i++){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) break;
            for (int i = bottom; i >= top; i--){
                res.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int i = right; i >= left; i--){
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = new ArrayList<>();
        res = spiralOrder(matrix);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
        System.out.println();
        List<Integer> res1 = new ArrayList<>();
        res1 = zero(matrix);
        for (int i = 0; i < res.size(); i++){
            System.out.print(res1.get(i));
        }
    }
}
