package 树的遍历;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class 二叉树的后序遍历 {

    // 递归
    public List<Integer> postorderTraversal0(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        postOrder(root, ans);
        return ans;
    }
    private void postOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);
    }

    // 递推1
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                stack2.push(p);
                p = p.right;
            }
            p = stack.pop().left;
        }
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        return ans;
    }

    // 递推2
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        TreeNode p = root;
        if (p == null) {
            return ans;
        }
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            stack2.push(p);
            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }
        }
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().val);
        }
        return ans;
    }


}
