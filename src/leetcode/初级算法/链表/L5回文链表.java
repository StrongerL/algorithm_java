package leetcode.初级算法.链表;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

public class L5回文链表 {

    public boolean isPalindrome(ListNode head) {

        // 空链或者只有一个元素
        if (head == null || head.next == null) return true;

        // 使用快慢指针找到中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 对后半部分反转
        ListNode mid = slow.next;
        ListNode p = mid;
        ListNode q = p.next;
        while (q != null) {
            p.next = q.next;
            q.next = mid;
            mid = q;
            q = p.next;
        }

        // 两个指针对比元素
        while (mid != null) {
            if (head.val != mid.val) return false;
            mid = mid.next;
            head = head.next;
        }

        return true;

    }

}
