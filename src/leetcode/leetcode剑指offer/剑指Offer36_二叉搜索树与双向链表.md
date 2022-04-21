## 代码

```java
// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

// 递归
// class Solution {
//     Node prev, head;
//     public Node treeToDoublyList(Node root) {
//         if (root == null) return root;
//         trans(root);
//         head.left = prev;
//         prev.right = head;
//         return head;
//     }
//     private void trans(Node cur) {
//         if (cur == null) return;
//         trans(cur.left);
//         if (prev == null) {
//             head = cur;
//         } else {
//             prev.right = cur;
//         }
//         cur.left = prev;
//         prev = cur;
//         trans(cur.right);
//     }
// }

// 用栈模拟递归
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node prev = null;
        Node head = null;
        Deque<Node> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null) {
                prev.right = root;
            } else {
                head = root;
            }
            root.left = prev;
            prev = root;
            root = root.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
}
```

## 思路

记录前一个访问的节点。

## 参考

1. https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/