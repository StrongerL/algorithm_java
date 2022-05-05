## 代码

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        int idx = n % s.length();
        return s.substring(idx) + s.substring(0, idx);
    }
}
```

## 思路

略。

## 参考

略。