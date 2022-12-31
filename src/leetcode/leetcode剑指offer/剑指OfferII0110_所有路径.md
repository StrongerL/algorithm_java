# 代码

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new ArrayList<>());
        return ans;
    }

    void dfs(int[][] g, int idx, List<Integer> cur) {
        if (idx == g.length - 1) {
            cur.add(idx);
            ans.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        cur.add(idx);
        for (int next : g[idx]) {
            dfs(g, next, cur);
        }
        cur.remove(cur.size() - 1);
    }
}
```

# 思路

回溯

# 参考

1. 无。