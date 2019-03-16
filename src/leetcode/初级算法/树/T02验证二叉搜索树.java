package leetcode.初级算法.树;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */

public class T02验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {

        // 递归
        // return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // 递归中序遍历
        // List<Integer> list = new LinkedList<>();
        // inOrder(root, list);
        // for (int i = 0; i < list.size() - 1; i++) {
        //     if (list.get(i) >= list.get(i + 1))
        //         return false;
        // }
        // return true;


        // 非递归中序遍历,使用栈
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                if (pre != null && root.val <= pre.val) return false;
                pre = root;
                root = root.right;
            }
        }

        return true;

    }

    // 递归
    // public boolean valid(TreeNode root, long low, long high) {
    //     if (root == null) return true;
    //     if (root.val <= low || root.val >= high) return false;
    //     return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    // }

    // 递归中序遍历
    // public void inOrder(TreeNode root, List<Integer> list) {
    //     if (root == null) return;
    //     inOrder(root.left, list);
    //     list.add(root.val);
    //     inOrder(root.right, list);
    // }

}
