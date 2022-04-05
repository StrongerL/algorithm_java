## 代码

```java
// 快速幂
// https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double ans = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) ans *= x;
            x *= x;
            b >>= 1;
        }
        return ans;
    }
}

```

## 思路

快速幂

## 参考

1. https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/