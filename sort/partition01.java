package sort;

public class partition01 {
    public static void partition(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;

        for (int i = 0; i <= right; ) {
            if (array[i] < k) {
                swap(array, i, left);
                left++;
                i++; // 向右移动，继续考察下一个元素
            } else if (array[i] > k) {
                swap(array, i, right);
                right--;
                // 注意：此时不需要移动 i，因为交换过来的元素还没有被考察过
            } else {
                // 相等的情况，直接跳过，继续考察下一个元素
                i++;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 打印数组
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1,3, 2, 4, 5, 1, 3};
        int k = 3;

        System.out.println("Original array:");
        printArray(array);

        partition(array, k);

        System.out.println("Partitioned array:");
        printArray(array);
    }

}
