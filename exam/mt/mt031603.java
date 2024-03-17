package exam.mt;

import java.util.Scanner;

public class mt031603 {
    public static void main(String[] args) {
        double a = 1e9 + 7;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组大小
        int q = scanner.nextInt(); // 操作次数
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        for (int j = 0; j < q; j++){
            int op = scanner.nextInt();
            for (int k = 0; k < n; k++){
                if (k != op - 1){
                    arr[k] *= 2;
                }
            }
        }
        int sum = 0;
        for(int m = 0; m < n; m++){
            sum += arr[m];
        }
        // 输出
        System.out.println((int)(sum % (1e9+7)));
    }
}
