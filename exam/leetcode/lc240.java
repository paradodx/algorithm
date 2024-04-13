package exam.leetcode;

public class lc240 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++){
            int left = 0, right = matrix[0].length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if (target < matrix[i][mid]){
                    right = mid - 1;
                } else if (target > matrix[i][mid]) {
                    left = mid + 1;
                }else return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length){
            if (target < matrix[i][j]) i--;
            else if (target > matrix[i][j]) j++;
            else return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean flag = searchMatrix(matrix, 5);
        boolean flag2 = searchMatrix2(matrix, 8);
        System.out.println(flag);
        System.out.println(flag2);
    }
}
