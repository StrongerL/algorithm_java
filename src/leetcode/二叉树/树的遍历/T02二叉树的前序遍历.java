package leetcode.二叉树.树的遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T02二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {

        // 19.36
        // 递归
        // List<Integer> t = new LinkedList<>();
        // preOrder(root, t);
        // return t;

        // 非递归
//        List<Integer> t = new LinkedList<>();
//        Stack<TreeNode> s = new Stack();
//        if (root == null) return t;
//        s.push(root);
//        while (!s.isEmpty()) {
//            TreeNode tmp = s.pop();
//            t.add(tmp.val);
//            if (tmp.right != null) s.push(tmp.right);
//            if (tmp.left != null) s.push(tmp.left);
//        }
//        return t;


//         非递归2
         List<Integer> t = new LinkedList<>();
         Stack<TreeNode> s = new Stack<>();
         while (root != null || !s.isEmpty()) {
             if (root != null) {
                 t.add(root.val);
                 s.push(root);
                 root = root.left;
             } else {
                 root = s.pop();
                 root = root.right;
             }
         }
         return t;

    }


    // 递归
    // public void preOrder(TreeNode root, List t) {
    //     if (root == null) return;
    //     t.add(root.val);
    //     preOrder(root.left, t);
    //     preOrder(root.right, t);
    // }

}
