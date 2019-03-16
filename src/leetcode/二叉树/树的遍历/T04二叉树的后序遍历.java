package leetcode.二叉树.树的遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

public class T04二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {

        // 20.19
        // 递归
        // List<Integer> t = new LinkedList<>();
        // postOrder(root, t);
        // return t;

        // 20.22
        // 非递归，双栈法
        List<Integer> t = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> ss = new Stack<>();
        while (root != null || !s.isEmpty()) {
            if (root != null) {
                s.push(root);
                ss.push(root);
                root = root.right;
            } else {
                root = s.pop();
                root = root.left;
            }
        }

        while (!ss.isEmpty()) {
            t.add(ss.pop().val);
        }

        return t;


    }

    // public void postOrder(TreeNode root, List t) {
    //     if (root == null) return;
    //     postOrder(root.left, t);
    //     postOrder(root.right, t);
    //     t.add(root.val);
    // }

}
