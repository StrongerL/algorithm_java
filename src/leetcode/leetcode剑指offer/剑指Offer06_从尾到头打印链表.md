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
// class Solution {
//     public int[] reversePrint(ListNode head) {
//         int len = 0;
//         ListNode p = head;
//         while (p != null) {
//             len++;
//             p = p.next;
//         }
//         int[] ans = new int[len];
//         p = head;
//         for (int i = 0; i < len; i++) {
//             ans[len - 1 - i] = p.val;
//             p = p.next;
//         }
//         return ans;
//     }
// }

// 评论区：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/596683
// 递归
class Solution {
    int i;
    int j;
    int[] ans;
    
    public int[] reversePrint(ListNode head) {
        solve(head);
        return ans;
    }

    private void solve(ListNode head) {
        if (head == null) {
            ans = new int[i];
            return;
        }
        i++;
        solve(head.next);
        ans[j++] = head.val;
    }
}
```

## 思路

递归

## 参考

1. 评论区：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/596683