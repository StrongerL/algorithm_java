# 代码

```java
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length / 2; i++) {
            int tmp = candidates[i];
            candidates[i] = candidates[candidates.length - 1 - i];
            candidates[candidates.length - 1 - i] = tmp;
        }
        dfs(candidates, target, new ArrayList<>(), 0, -1);
        return ans;
    }

    void dfs(int[] candidates, int target, List<Integer> cur, int idx, int prv) {
        if (idx == candidates.length) {
            if (target == 0) ans.add(new ArrayList<>(cur));
            return;
        }
        if (prv == -1 || candidates[idx] != prv) dfs(candidates, target, cur, idx + 1, prv);
        if (target - candidates[idx] >= 0) {
            cur.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], cur, idx + 1, candidates[idx]);
            cur.remove(cur.size() - 1);
        }
    }
}
```

# 思路

回溯

# 参考

1. 无。