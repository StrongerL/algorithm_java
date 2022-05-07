## 代码

```java
// https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            // 进位
            int c = (a & b) << 1;
            // 非进位和
            a ^= b;
            b = c;
        }
        return a;
    }
}
```

## 思路

循环计算进位和非进位和，当进位为0时终止循环。

## 参考

1. https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/