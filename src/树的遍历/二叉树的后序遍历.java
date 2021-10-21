package 树的遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class 二叉树的后序遍历 {

    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
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

    // 递推3 记录最后一个访问的节点
    // https://www.jianshu.com/p/456af5480cee
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode lastVisit = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 栈顶元素要么左子树为null，要么左子树已经访问过
            p = stack.peek();
            // 右子树为null或者已经访问
            if (p.right == null || p.right == lastVisit) {
                ans.add(p.val);
                stack.pop();
                lastVisit = p;
                p = null;
            } else {
                p = p.right;
            }
        }
        return ans;
    }

}
