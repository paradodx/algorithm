package exam.leetcode;

import java.util.Arrays;

public class lc73 {

    public static void setZero(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowZ = new boolean[row];
        boolean[] colZ = new boolean[col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    rowZ[i] = colZ[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (rowZ[i] || colZ[j] == true) matrix[i][j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZero(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
