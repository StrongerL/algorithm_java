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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode f = head;
        ListNode s = head;
        for (int i = 0; i < k; i++) f = f.next;
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}
```

## 思路

略。

## 参考

无。