package a02Listnode;

/*
* 查找有环链表的第一个环结点
* 相交链表
* */

public class getInsect {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static ListNode cycleNode(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /*
     * 两个无环链表相交
     * */
    public static ListNode noLoop(ListNode head1, ListNode head2){
        if(head1 == null || head2 ==null){
            return null;
        }
        ListNode cur1 = head1, cur2 = head2;
        int n = 0;
        // 遍历第一个链表，记录长度n（0开始++）
        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        // 遍历第二个链表，记录长度（n开始--）
        while(cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        // 如果n > 0说明第一个链表更长，将长的赋给cur1
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n); // 求此时n的绝对值，即为长链表比短链表多出的长度
        while(n != 0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2){
        ListNode cur1 = null, cur2 = null;
        // 两个链表有共同的一个环,并且相交结点再环之前
        if (loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            // 遍历第一个链表，记录长度n（0开始++）
            while (cur1.next != loop1){
                n++;
                cur1 = cur1.next;
            }
            // 遍历第二个链表，记录长度（n开始--）
            while(cur2.next != loop2){
                n--;
                cur2 = cur2.next;
            }
            if(cur1 != cur2){
                return null;
            }
            // 如果n > 0说明第一个链表更长，将长的赋给cur1
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n); // 求此时n的绝对值，即为长链表比短链表多出的长度
            while(n != 0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            // 环结点在相交结点之前，cur1来到环的下一个结点一直往后，在回到环结点之前遇到另一个链表的环结点则相交
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
            }
            cur1 = cur1.next;
        }
        return null;
    }

    public static ListNode getInsect(ListNode head1, ListNode head2){
        if (head1 ==null || head2 == null){
            return null;
        }
        ListNode loop1 = cycleNode(head1);
        ListNode loop2 = cycleNode(head2);
        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        boolean flag = hasCycle(head);
        System.out.println(flag);
        ListNode Node = cycleNode(head);
        System.out.println(Node.val);
    }

}
