## 代码

```java
// class Solution {
//     public int numWays(int n) {
//         if (n < 2) return 1;
//         int[] dp = new int[n + 1];
//         dp[0] = dp[1] = 1;
//         for (int i = 2; i <= n; i++) {
//             dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//         }
//         return dp[n];
//     }
// }

class Solution {
    public int numWays(int n) {
        if (n < 2) return 1;
        int a = 1, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
```

## 思路

略。

## 参考

略。