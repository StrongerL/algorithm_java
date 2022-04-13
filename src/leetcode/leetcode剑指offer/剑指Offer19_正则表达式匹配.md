## 代码

```java
// https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode-s3jgn/
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = matches(s, p, i - 1, j - 1) && dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 2];
                    if (!dp[i][j] && matches(s, p, i - 1, j - 2)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == -1) return j == -1;
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }
}
```

## 思路

dp

## 参考

1. https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode-s3jgn/