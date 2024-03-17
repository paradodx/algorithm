package exam.mt;

import java.util.Scanner;

public class mt031601 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 菜品总数：n
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        int x = scanner.nextInt(sum); // 满减
        int y = scanner.nextInt(sum); // 红包
        System.out.println(sum - x - y);

    }
}
