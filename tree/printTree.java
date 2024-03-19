package tree;

import java.util.LinkedList;
import java.util.Queue;

public class printTree {


    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void preOrder(TreeNode head){
        if (head == null){
            return;
        }
        System.out.print(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }
    public static void ineOrder(TreeNode head){
        if (head == null){
            return;
        }
        ineOrder(head.left);
        System.out.print(head.val + " ");
        ineOrder(head.right);
    }
    public static void posOrder(TreeNode head){
        if (head == null){
            return;
        }
        posOrder(head.left);
        System.out.print(head.val + " ");
        posOrder(head.right);
    }
    public static void width(TreeNode head){
        if (head == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        preOrder(head);
        System.out.println();
        ineOrder(head);
        System.out.println();
        posOrder(head);
        System.out.println();
        width(head);
    }

}
