package leetcode.二叉树.总结;

/**
 * 给定一个二叉树
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

public class S04填充每个节点的下一个右侧节点指针II {

    public Node connect(Node root) {

        // 层次遍历
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


        // 递归
//         if (root == null) return root;
//         Node p = root.next;

//         while (p != null) {
//             if (p.left != null) {
//                 p = p.left;
//                 break;
//             }
//             if (p.right != null) {
//                 p = p.right;
//                 break;
//             }
//             p = p.next;
//         }

//         if (root.left != null) root.left.next = (root.right != null) ? root.right : p;
//         if (root.right != null) root.right.next = p;

//         // 顺序不可变
//         connect(root.right);
//         connect(root.left);

//         return root;


        // 深度指针 + 层次指针
        Node dummpy = new Node(0);
        Node cur = dummpy;
        Node p = root;
        while (p != null) {
            if (p.left != null) {
                cur.next = p.left;
                cur = cur.next;
            }
            if (p.right != null) {
                cur.next = p.right;
                cur = cur.next;
            }
            p = p.next;
            if (p == null) {
                cur = dummpy;
                p = cur.next;
                // 不写会进入死循环
                cur.next = null;
            }
        }

        return root;

    }

}
