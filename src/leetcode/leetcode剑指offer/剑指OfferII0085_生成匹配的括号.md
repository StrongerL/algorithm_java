# 代码

```java
class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, n);
        return ans;
    }

    void dfs(StringBuilder cur, int left, int n) {
        if (cur.length() == n * 2) {
            ans.add(cur.toString());
            return;
        }
        if (n * 2 - cur.length() > left) {
            cur.append('(');
            dfs(cur, left + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (left > 0) {
            cur.append(')');
            dfs(cur, left - 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
```

# 思路

回溯

# 参考

1. 无。





