package 树的遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class 二叉树的中序遍历 {

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
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
    public List<Integer> inorderTraversal1(TreeNode root) {
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

    // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
    public List<Integer> inorderTraversalMorris(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            prev = cur.left;
            if (prev != null) {
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    ans.add(cur.val);
                    prev.right = null;
                    cur = cur.right;
                }
            } else {
                ans.add(cur.val);
                cur = cur.right;
            }
        }
        return ans;
    }

}
