package a01Sort;

import java.util.Arrays;

public class insert01 {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            // i = 1时j = 0 -> j & j + 1
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 5 ,1 ,3, 6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
