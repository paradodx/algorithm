package exam.leetcode;

public class lc74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row][col]) return false;
        int i = matrix.length - 1, j = 0;
        while(i >= 0){
            if (matrix[i][j] > target) i--;
        }
        int left = 0, right = col;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (target < matrix[i][mid]){
                right = mid - 1;
            }else if(target > matrix[i][mid]){
                left = mid + 1;
            } else return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
