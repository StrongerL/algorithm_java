package 树的遍历;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class 二叉树的中序遍历 {

    // 递归
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        inOrder(root, ans);
        return ans;
    }
    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    // 递推1
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            ans.add(p.val);
            p = p.right;
        }
        return ans;
    }


}
