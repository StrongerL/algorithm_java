# 代码

```java
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
        for (int j = 1; j <= n; j++) dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
        for (int i = 1; i <= m; i++) {
            char a = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char b = s2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + a, dp[i][j - 1] + b);
                }
            }
        }
        return dp[m][n];
    }
}
```

# 思路

`dp[i][j]`表示 `s1[0 : i - 1]`和`s2[0 : j - 1]`相等所需删除字符的 **ASCII** 值的最小和。

# 参考

1. 无。