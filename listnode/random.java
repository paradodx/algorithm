package listnode;

import java.util.HashMap;

/*
* 带有random指针的链表
* */

public class random {
    public static class Node{
        public int value;
        public Node next;
        public Node random;
        public Node(int data){
            this.value = data;
        }
    }

    private static void printList(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    private static void printListR(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.value + " ");
            cur = cur.random;
        }
        System.out.println();
    }

    public static Node copyNode(Node head){
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        while(cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            // map.get()新节点
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next; // 3
        head.next.next.random = head.next.next.next.next; // 5
        head.next.next.next.random = head.next.next.next; // 4
        head.next.next.next.next.random = null; //
        Node head2 = copyNode(head);
        printList(head);
        printListR(head2);
    }
}
