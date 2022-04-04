## 代码

```java
// https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-zhi-offer-14-i-jian-sheng-zi-huan-s-xopj/
// dp
// class Solution {
//     public int cuttingRope(int n) {
//         int[] dp = new int[n + 1];
//         dp[2] = 1;
//         for (int i = 3; i <= n; i++) {
//             for (int j = 2; j < i; j++) {
//                 dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
//             }
//         }
//         return dp[n];
//     }
// }

// 数学、贪心
class Solution {
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        return ans * n;
    }
}
```

## 思路

动态规划，或者数学分析。

## 参考

1. https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-zhi-offer-14-i-jian-sheng-zi-huan-s-xopj/