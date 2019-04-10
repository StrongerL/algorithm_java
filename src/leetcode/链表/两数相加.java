package leetcode.链表;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */



class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 递推
//         int sum = 0;
//         ListNode l = new ListNode(0);
//         ListNode head = l;
//         while (l1 != null || l2 != null) {
//             if (l1 != null) {
//                 sum += l1.val;
//                 l1 = l1.next;
//             }
//             if (l2 != null) {
//                 sum += l2.val;
//                 l2 = l2.next;
//             }

//             l.next = new ListNode(sum % 10);
//             sum /= 10;
//             l = l.next;
//         }

//         if (sum == 1)
//             l.next = new ListNode(1);

//         return head.next;


        // 递归
        ListNode l = new ListNode(0);
        addTwoNumbers(l1, l2, l, 0);
        return l.next;


    }


    private void addTwoNumbers(ListNode l1, ListNode l2, ListNode l, int up) {
        if (l1 == null && l2 == null) {
            if (up == 1)
                l.next = new ListNode(1);
            return;
        }
        if (l1 != null) {
            up += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            up += l2.val;
            l2 = l2.next;
        }
        l.next = new ListNode(up % 10);
        l = l.next;
        addTwoNumbers(l1, l2, l, up / 10);
    }


}
