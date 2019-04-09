package leetcode.二叉树.路径;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Easy
 *
 * 804
 *
 * 64
 *
 * Favorite
 *
 * Share
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }


public class BinaryTreePaths {

    private List<String> list = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null)
            return list;
        preOrder(root, "" + root.val);

        return list;
    }

    private void preOrder(TreeNode root, String path) {

        if (root.left == null && root.right == null) {
            list.add(path);
        }
        if (root.left != null) {
            preOrder(root.left, path + "->" + root.left.val);
        }
        if (root.right != null) {
            preOrder(root.right, path + "->" + root.right.val);
        }

    }

}
