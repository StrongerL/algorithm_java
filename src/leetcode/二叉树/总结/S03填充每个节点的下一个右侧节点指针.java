package leetcode.二叉树.总结;

/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 提示：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


public class S03填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {

        // 1. 层次遍历
//         if (root == null) return root;
//         Queue<Node> q = new LinkedList<>();
//         q.offer(root);

//         while (!q.isEmpty()) {
//             Node pre = null;
//             Node cur = null;
//             for (int i = q.size(); i > 0; i --){
//                 cur = q.poll();
//                 if (pre != null) pre.next = cur;
//                 if (i == 1) cur.next = null;
//                 pre = cur;
//                 if (cur.left != null) q.offer(cur.left);
//                 if (cur.right != null) q.offer(cur.right);
//             }
//         }

//         return root;

        // 2. 递归
        if (root == null || root.left == null) return root;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;


        // 3. 深度指针+层次指针
        // if (root == null) return root;
        // Node cur = null;
        // Node start = root;
        // while (start.left != null) {
        //     cur = start;
        //     while (cur != null) {
        //         cur.left.next = cur.right;
        //         if (cur.next != null)
        //             cur.right.next = cur.next.left;
        //         cur = cur.next;
        //     }
        //     start = start.left;
        // }
        // return root;

    }

}
