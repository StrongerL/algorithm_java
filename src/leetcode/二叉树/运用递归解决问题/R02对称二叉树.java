package leetcode.二叉树.运用递归解决问题;

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

public class R02对称二叉树 {

    public boolean isSymmetric(TreeNode root) {

        // 递归
        // if (root == null) return true;
        // return isSymmetric(root.left, root.right);


        // 非递归
        if (root == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(root.right);
        s.push(root.left);
        while (!s.isEmpty()) {
            TreeNode l = s.pop();
            TreeNode r = s.pop();
            if (l == null && r == null) continue;
            if (l == null || r == null || l.val != r.val) return false;
            s.push(l.left);
            s.push(r.right);
            s.push(l.right);
            s.push(r.left);
        }
        return true;
    }


    // public boolean isSymmetric(TreeNode left, TreeNode right) {
    //     if (left == null || right == null) return left == right;
    //     if (left.val != right.val) return false;
    //     return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    // }

}
