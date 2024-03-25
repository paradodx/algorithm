package exam.leetcode;

import java.util.Arrays;

public class lc189 {
    static class Node{
        int val;
        Node next;
        Node(int v){
            this.val = v;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // 数组长度 < 2 或者数组移动它长度的次数 = 不移动
        if (n < 2 || k % n == 0) return;
        k = k % n;
        // 创建链表
        Node head = new Node(nums[0]);
        Node cur = head;
        for (int i = 1; i < n; i++){
            cur.next = new Node(nums[i]);
            cur = cur.next;
        }
        // 尾结点指向头结点
        cur.next = head;
        // 此时指针在尾结点，要从移动k长度的地方开始遍历
        int step = n - k + 1;
        while(step > 0){
            cur = cur.next;
            step--;
        }
        // 遍历
        for (int i = 0; i < n; i++){
            nums[i] = cur.val;
            cur = cur.next;
        }
    }
    public static void rotate2(int[] nums, int k){
        int n = nums.length;
        if(n < 2 || k % n == 0) return;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        rotate2(nums2, 3);
        System.out.println(Arrays.toString(nums2));
    }
}
