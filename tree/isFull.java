package tree;

public class isFull {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info{
        public int height;
        public int nodes;
        public Info(int h, int n){
            height = h;
            nodes = n;
        }
    }
    public static Info process(TreeNode head){
        if(head == null){
            return new Info(0, 0);
        }
        Info leftData = process(head.left);
        Info rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new Info(height, nodes);
    }

    public static boolean isFull(TreeNode head){
        if(head == null){
            return true;
        }
        Info data = process(head);
        return data.nodes == ((1 << data.height) - 1);
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);
        boolean flag = isFull(head);
        System.out.println(flag);
    }
}
