package 树的遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 同leetcode.初级算法.树.T04二叉树的层次遍历.java
 *
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */

public class 二叉树的层次遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new LinkedList();

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> l = new LinkedList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode t = q.poll();
                l.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(l);
        }

        return res;
    }

}
