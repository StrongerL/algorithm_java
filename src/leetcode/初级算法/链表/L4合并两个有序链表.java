package leetcode.初级算法.链表;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class L4合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 15.30

//         if (l1 == null) return l2;
//         if (l2 == null) return l1;

//         ListNode p = l1;
//         ListNode q = l2;
//         ListNode k, head;

//         if (p.val <= q.val) {
//             head = p;
//             p = p.next;
//         } else {
//             head = q;
//             q = q.next;
//         }

//         k = head;

//         while (p != null && q != null) {
        // 应该用if
//             while (p != null && p.val <= q.val) {
//                 k.next = p;
//                 p = p.next;
//                 k = k.next;
//             }
//             while (q != null && p != null && p.val > q.val) {
//                 k.next = q;
//                 q = q.next;
//                 k = k.next;
//             }

//         }

//         if (p == null) {
//             k.next = q;
//         } else {
//             k.next = p;
//         }

//         return head;


        // 改进, 使用头节点
//         ListNode head = new ListNode(0);
//         ListNode p = head;

//         while (l1 != null && l2 != null) {
//             if (l1.val < l2.val) {
//                 p.next = l1;
//                 l1 = l1.next;
//             } else {
//                 p.next = l2;
//                 l2 = l2.next;
//             }
//             p = p.next;
//         }

//         if (l1 == null)
//             p.next = l2;
//         else
//             p.next = l1;

//         return head.next;


        // 使用递归
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

}
