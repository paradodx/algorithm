package exam.mt;

import java.util.Scanner;

public class mt031605 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组大小
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        for (int j = 0; j < n; j++){
            int count = 0;
            arr[j] = -arr[j];
            for (int x = 0; x < n - 1; x++){
                for (int y = x + 1; y < n; y++){
                    if(arr[x] > arr[y]){
                        count++;
                    }
                }
            }
            arr[j] = -arr[j];
            System.out.print(count);
        }
    }
}
