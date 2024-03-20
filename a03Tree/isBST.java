package a03Tree;


/*
* BST：判断搜索二叉树
* */
public class isBST {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(){}

        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void ineOrder(TreeNode head){
        if (head == null){
            return;
        }
        ineOrder(head.left);
        System.out.print(head.val + " ");
        ineOrder(head.right);
    }
    public static int preValue = Integer.MIN_VALUE;
    public static boolean isBst(TreeNode head){
        // 空树 -> BST
        if(head == null){
            return true;
        }
        // 判断左树是否为BST
        boolean isLeftBst = isBst(head.left);
        if(!isLeftBst){
            return false;
        }
        // 左树是BST，判断当前值是否大于pre
        if(head.val < preValue){
            return false;
        }else {
            // 大于，将pre设置为当前值（后续值都要比当前值大）
            preValue = head.val;
        }
        // 若右树是BST则整棵树都是
        return isBst(head.right);
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(7);
        ineOrder(head);
        System.out.println();
        boolean flag = isBst(head);
        System.out.println(flag);
    }
}
