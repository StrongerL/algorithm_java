## 代码

```java
// https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/gou-jian-cheng-ji-shu-zu-by-leetcode-sol-aqg2/
// class Solution {
//     public int[] constructArr(int[] a) {
//         int n = a.length;
//         if (n == 0) return new int[0];
//         if (n == 1) return new int[]{1};
//         int[] preSum = new int[n];
//         preSum[0] = a[0];
//         for (int i = 1; i < n; i++) preSum[i] = a[i] * preSum[i - 1];
//         int[] ans = new int[n];
//         ans[n - 1] = preSum[n - 2];
//         int rightSum = a[n - 1];
//         for (int i = n - 2; i > 0; i--) {
//             ans[i] = preSum[i - 1] * rightSum;
//             rightSum *= a[i];
//         }
//         ans[0] = rightSum;
//         return ans;
//     }
// }

class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) return new int[0];
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) ans[i] = ans[i - 1] * a[i - 1];
        int rightSum = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= rightSum;
            rightSum *= a[i];
        }
        return ans;
    }
}
```

## 思路

前缀和。

## 参考

1. https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/gou-jian-cheng-ji-shu-zu-by-leetcode-sol-aqg2/