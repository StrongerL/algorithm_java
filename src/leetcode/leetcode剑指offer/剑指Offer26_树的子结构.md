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

    boolean ans = false;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (ans) return ans;
        if (A == null || B == null) return A == B;
        if (A.val == B.val) {
            if (isContain(A, B)) {
                ans = true;
                return ans;
            }
        }
        isSubStructure(A.left, B);
        isSubStructure(A.right, B);
        return ans;
    }

    private boolean isContain(TreeNode A, TreeNode B) {
        if (ans) return true;
        if (A == null) return A == B;
        if (B == null) return true;
        return A.val == B.val && isContain(A.left, B.left) && isContain(A.right, B.right);
    }

}
```

## 思路

递归

## 参考

无。