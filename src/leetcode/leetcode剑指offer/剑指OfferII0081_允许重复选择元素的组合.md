# 代码

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    void dfs(int[] candidates, int target, List<Integer> cur, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (idx == candidates.length) return;
        dfs(candidates, target, cur, idx + 1);
        if (target - candidates[idx] >= 0) {
            cur.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], cur, idx);
            cur.remove(cur.size() - 1);
        }
    }

}
```

# 思路

回溯

# 参考

1. 无。