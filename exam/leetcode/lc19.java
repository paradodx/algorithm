package exam.leetcode;

import java.util.List;

public class lc19 {
    /*
     * 遍历链表 -> 记录长度n
     * 正数第n - k个数就是要删的数
     * count = 0, 每遍历一个count++, if(count == n - k)
     * */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        if (head == null) return null;
        int len = len(head);
        for (int i = 0; i < len - n; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return pre.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static int len(ListNode head) {
        if (head == null) return 0;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = removeNthFromEnd(head, 2);
        print(head);
        System.out.println();
        ListNode head2 = new ListNode(1);
        head2 = removeNthFromEnd(head2, 1);
        print(head2);

    }

}
