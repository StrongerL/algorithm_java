package leetcode.二叉树.树的遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

public class T03中序遍历二叉树 {

    public List<Integer> inorderTraversal(TreeNode root) {

        // 19.55
        // 递归
        // List<Integer> t = new LinkedList<>();
        // inOrder(root, t);
        // return t;

        // 非递归
        List<Integer> t = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                t.add(root.val);
                root = root.right;
            }
        }
        return t;

    }

    // 递归
    // public void inOrder(TreeNode root, List t) {
    //     if (root == null) return;
    //     inOrder(root.left, t);
    //     t.add(root.val);
    //     inOrder(root.right, t);
    // }

}
