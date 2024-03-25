package test;

public class lc48 {

    public static void rotate(int[][] matrix) {
        int row = matrix.length - 1, col = matrix[0].length - 1;
        for (int j = 0; j <= col; j++){
            for (int i = row; i >=0; i--){
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println();
        rotate(arr);
    }
}
