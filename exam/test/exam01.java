package exam.test;

import java.util.Scanner;

public class exam01 {

    /*小美矩阵*/
    public static int[] count(int[][] matrix){
        int n = matrix.length;
        int[] perfect_rect = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int size = 1; size < Math.min(n - i, n - j) + 1; size++){
                    int count0 = 0, count1 = 0;
                    for (int x = i; x < i + size; x++){
                        for (int y = j; y < j + size; y++){
                            if(matrix[x][y] == 0){
                                count0 ++;
                            }
                            count1++;
                        }
                    }

                    if(count0 == count1){
                        perfect_rect[size - 1] += 1;
                    }
                }
            }
        }
        return perfect_rect;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数，表示矩阵大小：");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.println("请输入矩阵元素，空格隔开");
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] result = count(arr);
        for (int s : result){
            System.out.println(s);
        }
        // 输出
    }
}

