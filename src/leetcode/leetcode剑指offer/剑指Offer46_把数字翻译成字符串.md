## 代码

```java
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            dp[i] = dp[i - 1];
            int cur = Integer.parseInt(s.substring(i - 2, i));
            if (cur >= 10 && cur < 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
```

## 思路

dp。

## 参考

无。