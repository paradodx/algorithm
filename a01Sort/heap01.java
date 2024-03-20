package a01Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class heap01 {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    /*
     * 堆的调整：heapInsert
     * 将新插入的数与父节点比较，变成大根堆
     * */
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1)/2);
            index = (index - 1) / 2;
        }
    }

    /*
     * 某数在index位置，能否向下移动
     * */
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1; // 左孩子下标
        while(left < heapSize){  // 还有孩子节点
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left; // 比较大的节点
            largest = arr[largest] > arr[index] ? largest : index; // 父和较大孩子节点比较，大的值给largest
            if(largest == index){
                break;
            }else {
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        // arr数组变成大根堆
        for (int i = 0; i < arr.length; i++){
            heapInsert(arr, i);
        }
        // 将第一个数（max）弹出（与heapSize（最后一个数）交换位置）
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }


    /*
    * PriorityQueue默认小根堆结构，只能实现add和poll，不适用于改变其中的某个元素
    * 几乎有序的数组（将数组排好序的话每个元素移动的距离不超过k）
    */
    public static void sortedArrDistanceLess(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        // 变成小根堆（前k个数）
        for (; index < Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; i++, index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 4, 6, 7, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
