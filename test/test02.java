package test;

/*
* 比k小的数在左边，比k大的数在右边，等于k的数在中间
* */
public class test02 {
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

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void partition(ListNode[] array, int k) {
        int left = 0;
        int right = array.length - 1;

        for (int i = 0; i <= right;) {
            if (array[i].val < k) {
                swap(array, i, left);
                left++;
                i++; // 向右移动，继续考察下一个元素
            } else if (array[i].val > k) {
                swap(array, i, right);
                right--;
                // 注意：此时不需要移动 i，因为交换过来的元素还没有被考察过
            } else {
                // 相等的情况，直接跳过，继续考察下一个元素
                i++;
            }
        }
    }

    private static void swap(ListNode[] array, int i, int j) {
        ListNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(3);
        printList(head);
        ListNode[] Node = new ListNode[7];
        for (int i = 0; i < 7; i++) {
            Node[i] = head;
            head = head.next;
        }
        for (int i = 0; i < 7;i++){
            System.out.print(Node[i].val + " ");
        }
        partition(Node, 3);
        System.out.println();
        for (int i = 0; i < 7;i++){
            System.out.print(Node[i].val + " ");
        }
    }
}
