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

        if (head == null || head.next == null) return true;

        // 得出中间的数，如果链表长度为单数，那么slow就是中间的数，如果为双数，那么slow和slow.next为中间的数
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 翻转右半部分
        ListNode left = head, right = slow.next;
        ListNode p = right, q = p.next;
        while (q != null) {
            p.next = q.next;
            q.next = right;
            right = q;
            q = p.next;
        }

        // 比较
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;


    }

}
