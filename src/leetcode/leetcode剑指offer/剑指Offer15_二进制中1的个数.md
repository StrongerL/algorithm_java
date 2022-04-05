## 代码

```java
// public class Solution {
//     // you need to treat n as an unsigned value
//     public int hammingWeight(int n) {
//         int ans = 0;
//         while (n != 0) {
//             ans += (1 & n);
//             n >>>= 1;
//         }
//         return ans;
//     }
// }

// https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/er-jin-zhi-zhong-1de-ge-shu-by-leetcode-50bb1/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ans++;
        }
        return ans;
    }
}
```

## 思路

n &= (n - 1) 可以去掉最后一个1。

## 参考

1. https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/er-jin-zhi-zhong-1de-ge-shu-by-leetcode-50bb1/