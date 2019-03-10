package leetcode.初级算法.树;

import java.util.Stack;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */

public class T03对称二叉树 {

    public boolean isSymmetric(TreeNode root) {

        // 递归
        // if (root == null) return true;
        // return isSymmetric(root.left, root.right);

        // 非递归
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(root.left);
        s.push(root.right);
        while (!s.isEmpty()) {
            TreeNode right = s.pop();
            TreeNode left = s.pop();
            if (left == null && right == null) continue;
            if (left == null || right ==null || left.val != right.val) return false;
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;

    }

    // 递归
    // public boolean isSymmetric(TreeNode left, TreeNode right) {
    //     if (left == null || right == null) return left == right;
    //     if (left.val != right.val) return false;
    //     return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    // }

}
