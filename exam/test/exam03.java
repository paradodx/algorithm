package exam.test;


import java.util.Scanner;

public class exam03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组大小
        int q = scanner.nextInt(); // 查询次数
        int[] arr = new int[n]; // 数组
        int zero = 0, sum = 0;
        int[] l = new int[q];
        int[] r = new int[q];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
            if (arr[i] == 0){
                zero++;
            }
        }
        // 输入查询l，r，q次
        for (int j = 0; j < q; j++){
            l[j] = scanner.nextInt();
            r[j] = scanner.nextInt();
        }
        // 输出
        for (int k = 0; k < q; k++){
            System.out.printf("%d %d\n",sum + zero * l[k], sum + zero * r[k]);
        }


    }
}
