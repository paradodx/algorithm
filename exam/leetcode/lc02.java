package exam.leetcode;

public class lc02 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        while(head1 != null){
            if (head2 != null){
                head1.val += head2.val;
                head2 = head2.next;
            }
            if (head1.next == null && head2 != null){
                head1.next = head2;
                break;
            }
            head1 = head1.next;
        }
        merge(l1);
        return l1;
    }

    public static void merge(ListNode head){
        while(head != null){
            if (head.val >= 10){
                head.val = head.val % 10;
                if (head.next == null){
                    head.next = new ListNode(0);
                }
                head.next.val += 1;
            }
            head = head.next;
        }
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l1 = addTwoNumbers(l1, l2);
        print(l1);
    }

}
