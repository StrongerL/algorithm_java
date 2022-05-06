## 代码

```java
// https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
// dp，逆推，无空间优化
// class Solution {
//     public double[] dicesProbability(int n) {
//         double[][] dp = new double[n][n * 6];
//         for (int j = 0; j < 6; j++) dp[0][j] = 1.0 / 6.0;
//         for (int i = 1; i < n; i++) {
//             for (int j = i; j < (i + 1) * 6; j++) {
//                 for (int k = 1; k <= 6 && j - k >= 0; k++) {
//                     dp[i][j] += dp[i - 1][j - k] / 6.0;
//                 }
//             }
//         }
//         int len = n * 5 + 1;
//         double[] ans = new double[len];
//         System.arraycopy(dp[n - 1], n - 1, ans, 0, len);
//         return ans;
//     }
// }

// dp，正推，空间优化
class Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] prev = dp;
            dp = new double[i * 5 + 1];
            for (int j = 0; j < prev.length; j++) {
                for (int k = 0; k < 6; k++) {
                    dp[j + k] += prev[j] / 6.0;
                }
            }
        }
        return dp;
    }
}
```

## 思路

dp

## 参考

1. https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/

