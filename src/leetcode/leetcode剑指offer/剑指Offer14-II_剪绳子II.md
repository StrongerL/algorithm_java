## 代码

```java
class Solution {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        long ans = 1;
        while (n > 4) {
            ans = (ans * 3) % 1000000007;
            n -= 3;
        }
        return (int)((ans * n) % 1000000007);
    }
}
```

## 思路

参考 I

## 参考

参考 I