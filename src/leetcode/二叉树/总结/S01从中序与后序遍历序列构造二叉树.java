package leetcode.二叉树.总结;

/**
 * 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class S01从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 后序遍历最后一个为根，从而将中序遍历分为左右子树，然后不断迭代
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }


    public TreeNode build(int[] inorder, int[] postorder, int postend, int instart, int inend) {

        if (instart > inend) return null;

        TreeNode root = new TreeNode(postorder[postend]);
        int index = 0;
        for (int i = instart; i <= inend; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.right = build(inorder, postorder, postend - 1, index + 1, inend);
        // (inend - index)为右子树长度
        root.left = build(inorder, postorder, postend - 1 - (inend - index), instart, index - 1);
        return root;
    }

}
