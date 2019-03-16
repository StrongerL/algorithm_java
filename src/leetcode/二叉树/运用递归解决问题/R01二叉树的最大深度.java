package leetcode.二叉树.运用递归解决问题;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class R01二叉树的最大深度 {

    public int maxDepth(TreeNode root) {

        // 9.00
        // 递归
        // if (root == null) return 0;
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // 9.02
        // 非递归
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return depth;
        q.offer(root);
        while (!q.isEmpty()) {
            depth++;
            for (int i = q.size(); i > 0; i--) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return depth;
        // 9.09
    }

}
