## 代码

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private HashMap<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int idx, int[] inorder, int left, int right) {
        if (left > right) return null;
        int mid = idxMap.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx]);
        root.left = buildTree(preorder, idx + 1, inorder, left, mid - 1);
        root.right = buildTree(preorder, idx + mid - left + 1, inorder, mid + 1, right);
        return root;
    }

}
```

## 思路

略。

## 参考

略。