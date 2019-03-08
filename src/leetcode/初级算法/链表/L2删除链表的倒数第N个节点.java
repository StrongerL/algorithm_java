package leetcode.初级算法.链表;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */

public class L2删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 两趟扫描
        // 确定长度
//         ListNode p = head;
//         int count = 1;
//         while (p.next != null) {
//             count++;
//             p = p.next;
//         }

//         // 删除的节点是第一个节点
//         if (count == n) {
//             return head.next;
//         }

//         // 删除的节点不是第一个节点
//         p = head;
//         for (int i = 0; i < count - 1 - n; i++) {
//             p = p.next;
//         }

//         p.next = p.next.next;
//         return head;

        // 使用快慢指针思想
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n + 1; i++) {
            // 删除的节点是第一个节点
            if (fast == null) return head.next;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

}
