import java.util.Scanner;

import static a01Sort.heap01.heapInsert;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++){
            System.out.println("请输入第" + (i + 1) + "个元素：");
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("输入的数组为：");
        for (int num : arr){
            System.out.print(num);
        }

        System.out.println("请输入一个");
        int a = scanner.nextInt();
        heapInsert(arr, length);
    }
}