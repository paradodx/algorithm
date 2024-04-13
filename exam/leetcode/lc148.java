package exam.leetcode;

import java.util.Arrays;

public class lc148 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode sortList(ListNode head){
        if (head == null || head.next == null) return head;
        int n = len(head);
        int[] res = new int[n];
        ListNode cur = head;
        for (int i = 0; i < n; i++){
            res[i] = cur.val;
            cur = cur.next;
        }
        Arrays.sort(res);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        cur = dummy;
        for (int num : res){
            cur.next.val = num;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static int len(ListNode head){
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        return len;
    }

    public static void print(ListNode head){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = sortList(head);
        print(head);
    }
}
