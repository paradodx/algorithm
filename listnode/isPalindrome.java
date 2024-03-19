package listnode;

/*
* 回文链表
* */

public class isPalindrome {
     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public static boolean isPalindrome(ListNode head) {
        ListNode left = midNode(head);
        ListNode right = reverse(left.next);
        ListNode temp1 = head;
        ListNode temp2 = right;
        while (temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        right = reverse(right);
        left.next = right;
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        printList(head);
        boolean flag = isPalindrome(head);
        System.out.println(flag);
        printList(head);
    }
}
