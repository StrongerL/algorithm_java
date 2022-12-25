# 代码

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(new ArrayList<>(), n, k, 1);
        return ans;
    }

    void dfs(List<Integer> cur, int n, int k, int idx) {
        if (cur.size() + n - idx + 1< k) return;
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        dfs(cur, n, k, idx + 1);
        cur.add(idx);
        dfs(cur, n, k, idx + 1);
        cur.remove(cur.size() - 1);
    }

}
```

# 思路

回溯+剪枝

# 参考

1. 无。

