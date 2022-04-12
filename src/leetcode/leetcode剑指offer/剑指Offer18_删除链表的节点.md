## 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        ListNode p = head;
        ListNode current;
        while (p != null && p.next != null) {
            current = p.next;
            if (current.val == val) {
                p.next = current.next;
                break;
            }
            p = p.next;
        }
        return head;
    } 
}
```

## 思路

略。

## 参考

无。