package leetcode.初级算法.链表;

/**
 * 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class L3反转链表 {

    public ListNode reverseList(ListNode head) {
        // 14.20
        // 非递归
        // https://www.cnblogs.com/byrhuangqiang/p/4311336.html
        // 链表无元素
//         if (head == null) return head;

//         ListNode p = head;
//         ListNode q = p.next;
//         while (q != null) {
//             p.next = q.next;
//             q.next = head;
//             head = q;
//             q = p.next;
//         }
//         return head;

        // 15.07
        // 递归
        if (head == null || head.next == null) return head;

        // head之后的list
        ListNode second = head.next;
        // 对head之后的list逆序
        ListNode newHead = reverseList(second);
        // 将head设为最后一个节点
        second.next = head;
        head.next = null;

        return newHead;
        // 15.21
    }

}
