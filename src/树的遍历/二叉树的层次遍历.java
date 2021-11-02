package 树的遍历;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
