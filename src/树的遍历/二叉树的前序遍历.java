package 树的遍历;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class 二叉树的前序遍历 {

    // 递归
    public List<Integer> preorderTraversal0(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        preOrder(root, ans);
        return ans;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // 递推1
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                ans.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return ans;
    }

    // 递推2
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        if (p == null) {
            return ans;
        }
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            ans.add(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return ans;
    }


}
