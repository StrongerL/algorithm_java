## 代码

```java
// class Solution {
//     public int fib(int n) {
//         int[] dp = new int[101];
//         dp[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//         }
//         return dp[n];
//     }
// }

// 动规优化
class Solution {
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) return n;
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = (p + q) & MOD;
        }
        return r;
    }
}

```

## 思路

1. 动态规划
2. 矩阵快速幂 TODO

## 参考

1. https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/fei-bo-na-qi-shu-lie-by-leetcode-solutio-hbss/