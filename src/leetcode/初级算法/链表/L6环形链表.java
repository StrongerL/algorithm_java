package leetcode.初级算法.链表;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */

public class L6环形链表 {

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        // 如果存在环，快慢指针终将相遇
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

}
