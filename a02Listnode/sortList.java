package a02Listnode;

public class sortList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;
        }
    }

    // 排序
    public static ListNode mergeSort(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode rightHead = mergeSort(mid.next);
        mid.next = null;
        ListNode leftHead = mergeSort(head);
        return mergeList(leftHead, rightHead);
        }
    // 获取链表中间值
    public static ListNode getMid(ListNode head){
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    // 合并有序链表
    public static ListNode mergeList(ListNode head1, ListNode head2){
        if (head1 == null) return head2;
        else if (head2 == null) return head1;
        else {
            ListNode head = head1.val <= head2.val ? head1 : head2;
            ListNode cur1 = head.next;
            ListNode cur2 = head == head1 ? head2 : head1;
            ListNode pre = head;
            while(cur1 != null && cur2 != null){
                if(cur1.val <= cur2.val){
                    pre.next = cur1;
                    cur1 = cur1.next;
                }else{
                    pre.next = cur2;
                    cur2 = cur2.next;
                }
                pre = pre.next;
            }
            pre.next = cur1 == null ? cur2 : cur1;
            return head;
        }
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
        head = mergeSort(head);
        print(head);
    }
}
