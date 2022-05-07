## 代码

```java
// https://leetcode-cn.com/problems/qiu-12n-lcof/solution/qiu-12n-by-leetcode-solution/
class Solution {
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
```

## 思路

使用`&&`的短路判断，作为递归的终止条件。

## 参考

1. https://leetcode-cn.com/problems/qiu-12n-lcof/solution/qiu-12n-by-leetcode-solution/