package heap;

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
     * 去掉大根堆中最大的数（第0个数）后，末位数补齐至0位置，与子节点数进行比较
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
}
