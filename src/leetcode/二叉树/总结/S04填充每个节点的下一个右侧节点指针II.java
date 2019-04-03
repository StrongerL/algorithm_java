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
//        if (root == null) return root;
//        Node p = root.next;
//        Node next = null;
//
//        while (p != null) {
//            if (p.left != null) {
//                next = p.left;
//                break;
//            }
//            if (p.right != null) {
//                next = p.right;
//                break;
//            }
//            p = p.next;
//        }
//
//        if (root.left != null)
//            root.left.next = (root.right == null) ? next : root.right;
//        if (root.right != null)
//            root.right.next = next;
//
//        // 右边必须已经连接好，所以先递归右子树
//        connect(root.right);
//        connect(root.left);
//
//        return root;


        // 深度指针 + 层次指针
        Node start = new Node(0);
        // 遍历当前层
        Node parent = root;
        // 遍历儿子节点层，即当前层的下一层
        Node cur = start;
        while (parent != null) {
            if (parent.left != null) {
                cur.next = parent.left;
                cur = cur.next;
            }
            if (parent.right != null) {
                cur.next = parent.right;
                cur = cur.next;
            }
            parent = parent.next;
            // 如果当前层无更多节点，parent和cur都下降一层
            if (parent == null) {
                parent = start.next;

                start.next = null;
                cur = start;
            }
        }

        return root;

    }

}
