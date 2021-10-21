package 树的遍历;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.right = t6;

        二叉树的前序遍历 solution1 = new 二叉树的前序遍历();
        System.out.println(solution1.preorderTraversal(t1));

        二叉树的中序遍历 solution2 = new 二叉树的中序遍历();
        System.out.println(solution2.inorderTraversal(t1));

        二叉树的后序遍历 solution3 = new 二叉树的后序遍历();
        System.out.println(solution3.postorderTraversal(t1));
    }

}

